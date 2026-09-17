package agm_system.model;

public class Equipamento {
    private int idEquipamento;
    private String nome;
    private String categoria;
    private double valorDiaria;
    private String status; 

    public Equipamento() {
    }

    public Equipamento(int idEquipamento, String nome, String categoria, double valorDiaria, String status) {
        this.idEquipamento = idEquipamento;
        this.nome = nome;
        this.categoria = categoria;
        this.valorDiaria = valorDiaria;
        this.status = status;
    }

    public int getIdEquipamento() { return idEquipamento; }
    public void setIdEquipamento(int idEquipamento) { this.idEquipamento = idEquipamento; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public double getValorDiaria() { return valorDiaria; }
    public void setValorDiaria(double valorDiaria) { this.valorDiaria = valorDiaria; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}