package agm_system;

import agm_system.model.BancoDadosSimulado;
import agm_system.model.Cliente;
import javax.swing.*;
import java.awt.*;

public class TelaCadastroCliente extends JDialog {
    private JTextField txtNome, txtContato, txtLat, txtLong;
    private TelaPrincipal telaPai;

    public TelaCadastroCliente(TelaPrincipal parent) {
        super(parent, "Cadastro de Cliente", true);
        this.telaPai = parent;
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel painelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        painelForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        painelForm.add(new JLabel("Nome do Cliente: *"));
        txtNome = new JTextField();
        painelForm.add(txtNome);

        painelForm.add(new JLabel("Telefone/Contato: *"));
        txtContato = new JTextField();
        painelForm.add(txtContato);

        painelForm.add(new JLabel("Latitude (Geoprocessamento):"));
        txtLat = new JTextField("-21.7550");
        painelForm.add(txtLat);

        painelForm.add(new JLabel("Longitude (Geoprocessamento):"));
        txtLong = new JTextField("-41.3250");
        painelForm.add(txtLong);

        add(painelForm, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnCancelar);
        add(painelBotoes, BorderLayout.SOUTH);

        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText().trim();
            String contato = txtContato.getText().trim();
            
            if (nome.isEmpty() || contato.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Erro: Os campos Nome e Contato são obrigatórios!", "Validação", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                double lat = Double.parseDouble(txtLat.getText().trim());
                double lon = Double.parseDouble(txtLong.getText().trim());

                int novoId = BancoDadosSimulado.clientes.size() + 1;
                Cliente c = new Cliente(novoId, nome, contato, "Rua Padrão", "Bairro Padrão", "Campos", "RJ", "Brasil", lat, lon);
                
                BancoDadosSimulado.clientes.add(c);
                
                telaPai.atualizarTodasAsTabelas();
                dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Erro: Latitude e Longitude devem conter apenas números decimais (ex: -21.75).", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancelar.addActionListener(e -> dispose());
    }
}