package agm_system.model;

import java.util.ArrayList;
import java.util.List;

public class BancoDadosSimulado {
    public static List<Cliente> clientes = new ArrayList<>();
    public static List<Equipamento> equipamentos = new ArrayList<>();
    public static List<Contrato> contratos = new ArrayList<>();

    static {
        equipamentos.add(new Equipamento(1, "Britadeira", "Ferramentas", 100.0, "Disponível"));
        equipamentos.add(new Equipamento(2, "Betoneira", "Mistura", 120.0, "Disponível"));
        equipamentos.add(new Equipamento(3, "Mini Escavadeira", "Terraplanagem", 450.0, "Disponível"));
    }
}
