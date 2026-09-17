package agm_system;

import agm_system.model.BancoDadosSimulado;
import agm_system.model.Cliente;
import agm_system.model.Contrato;
import agm_system.model.Equipamento;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaPrincipal extends JFrame {
    private DefaultTableModel modeloClientes;
    private DefaultTableModel modeloEquipamentos;
    private DefaultTableModel modeloContratos;

    public TelaPrincipal() {
        setTitle("AGM System - Painel Dashboard Profissional");
        setSize(900, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("AGM SYSTEM - SISTEMA DE GESTÃO E LOGÍSTICA", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel painelMenu = new JPanel(new GridLayout(3, 1, 10, 10));
        painelMenu.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JButton btnCadCliente = new JButton("Cadastrar Cliente");
        JButton btnNovoContrato = new JButton("Criar Novo Contrato");

        painelMenu.add(btnCadCliente);
        painelMenu.add(btnNovoContrato);
        add(painelMenu, BorderLayout.WEST);

        JTabbedPane abasPainel = new JTabbedPane();

        modeloClientes = new DefaultTableModel(new Object[]{"ID", "Nome", "Contato", "Latitude", "Longitude"}, 0);
        JTable tabelaClientes = new JTable(modeloClientes);
        abasPainel.addTab("Clientes", new JScrollPane(tabelaClientes));

        modeloEquipamentos = new DefaultTableModel(new Object[]{"ID", "Nome", "Categoria", "Valor Diária", "Status"}, 0);
        JTable tabelaEquipamentos = new JTable(modeloEquipamentos);
        abasPainel.addTab("Equipamentos / Inventário", new JScrollPane(tabelaEquipamentos));

        modeloContratos = new DefaultTableModel(new Object[]{"Nº Contrato", "Cliente", "Local da Obra", "Início", "Entrega Prevista", "Total"}, 0);
        JTable tabelaContratos = new JTable(modeloContratos);
        abasPainel.addTab("Contratos Ativos", new JScrollPane(tabelaContratos));

        add(abasPainel, BorderLayout.CENTER);

        btnCadCliente.addActionListener(e -> {
            TelaCadastroCliente telaCad = new TelaCadastroCliente(this);
            telaCad.setVisible(true);
        });

        btnNovoContrato.addActionListener(e -> {
            TelaCadastroContrato telaContrato = new TelaCadastroContrato(this);
            telaContrato.setVisible(true);
        });

        atualizarTodasAsTabelas();
    }

    public void atualizarTodasAsTabelas() {
        modeloClientes.setRowCount(0);
        modeloEquipamentos.setRowCount(0);
        modeloContratos.setRowCount(0);

        for (Cliente c : BancoDadosSimulado.clientes) {
            modeloClientes.addRow(new Object[]{c.getIdCliente(), c.getNome(), c.getContato(), c.getLatitude(), c.getLongitude()});
        }

        for (Equipamento eq : BancoDadosSimulado.equipamentos) {
            modeloEquipamentos.addRow(new Object[]{eq.getIdEquipamento(), eq.getNome(), eq.getCategoria(), String.format("R$ %.2f", eq.getValorDiaria()), eq.getStatus()});
        }

        for (Contrato ct : BancoDadosSimulado.contratos) {
            modeloContratos.addRow(new Object[]{
                ct.getIdContrato(),
                ct.getCliente().getNome(),
                ct.getLocalObra().getLogradouro(),
                ct.getDataInicio(),
                ct.getDataFim(),
                String.format("R$ %.2f", ct.getValorTotal())
            });
        }
    }
}
