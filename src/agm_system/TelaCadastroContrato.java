package agm_system;

import agm_system.model.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TelaCadastroContrato extends JDialog {
    private JComboBox<String> comboClientes;
    private JComboBox<String> comboEquipamentos;
    private JFormattedTextField txtDataInicio;
    private JFormattedTextField txtDataFim;
    private JTextField txtObra;
    private TelaPrincipal telaPai;

    public TelaCadastroContrato(TelaPrincipal parent) {
        super(parent, "Abertura de Contrato de Locação", true);
        this.telaPai = parent;
        setSize(450, 350);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel painelForm = new JPanel(new GridLayout(5, 2, 10, 10));
        painelForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        painelForm.add(new JLabel("Selecione o Cliente:"));
        comboClientes = new JComboBox<>();
        for (Cliente c : BancoDadosSimulado.clientes) {
            comboClientes.addItem(c.getNome());
        }
        painelForm.add(comboClientes);

        painelForm.add(new JLabel("Equipamento Principal:"));
        comboEquipamentos = new JComboBox<>();
        for (Equipamento eq : BancoDadosSimulado.equipamentos) {
            comboEquipamentos.addItem(eq.getNome());
        }
        painelForm.add(comboEquipamentos);

        painelForm.add(new JLabel("Endereço/Local da Obra:"));
        txtObra = new JTextField("Rua da Obra, Campos");
        painelForm.add(txtObra);

        try {
            MaskFormatter mascaraData = new MaskFormatter("##/##/#### ##:##");
            mascaraData.setPlaceholderCharacter('_'); // Mostra os espaços vazios estruturados

            painelForm.add(new JLabel("Data/Hora Início (DD/MM/AAAA HH:MM):"));
            txtDataInicio = new JFormattedTextField(mascaraData);
            painelForm.add(txtDataInicio);

            painelForm.add(new JLabel("Previsão de Término (DD/MM/AAAA HH:MM):"));
            txtDataFim = new JFormattedTextField(mascaraData);
            painelForm.add(txtDataFim);

        } catch (ParseException e) {
            System.out.println("Erro na criação da máscara de digitação.");
        }

        add(painelForm, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        JButton btnSalvar = new JButton("Emitir Contrato");
        JButton btnCancelar = new JButton("Cancelar");
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnCancelar);
        add(painelBotoes, BorderLayout.SOUTH);

        btnSalvar.addActionListener(e -> {
            if (BancoDadosSimulado.clientes.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não é possível criar um contrato sem clientes cadastrados!", "Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String dataIniStr = txtDataInicio.getText().trim();
            String dataFimStr = txtDataFim.getText().trim();
            String localObraStr = txtObra.getText().trim();

            SimpleDateFormat formatadorValidador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            formatadorValidador.setLenient(false); 

            try {
                java.util.Date d1 = formatadorValidador.parse(dataIniStr);
                java.util.Date d2 = formatadorValidador.parse(dataFimStr);

                if (d2.before(d1)) {
                    JOptionPane.showMessageDialog(this, "Erro: A data de término não pode ser anterior à data de início!", "Erro de Cronograma", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Cliente clienteSelecionado = BancoDadosSimulado.clientes.get(comboClientes.getSelectedIndex());
                Equipamento equipamentoSelecionado = BancoDadosSimulado.equipamentos.get(comboEquipamentos.getSelectedIndex());

                if (!equipamentoSelecionado.getStatus().equalsIgnoreCase("Disponível")) {
                    JOptionPane.showMessageDialog(this, "Aviso: O equipamento '" + equipamentoSelecionado.getNome() + "' não está disponível para locação no momento.", "Equipamento Indisponível", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                LocalObra lo = new LocalObra();
                lo.setLogradouro(localObraStr);

                int novoIdContrato = BancoDadosSimulado.contratos.size() + 1;
                
                Contrato novoContrato = new Contrato(novoIdContrato, dataIniStr, dataFimStr, "Ativo", clienteSelecionado, lo);
                
                novoContrato.adicionarEquipamento(equipamentoSelecionado);

                equipamentoSelecionado.setStatus("Alugado");

                BancoDadosSimulado.contratos.add(novoContrato);

                JOptionPane.showMessageDialog(this, "Contrato emitido e registrado no fluxo logístico com sucesso!");
                telaPai.atualizarTodasAsTabelas(); 
                dispose();

            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Erro de Agendamento: Formato de Data ou Hora inválido!\nUse o padrão DD/MM/AAAA HH:MM.", "Validação de Cronograma", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancelar.addActionListener(e -> dispose());
    }
}