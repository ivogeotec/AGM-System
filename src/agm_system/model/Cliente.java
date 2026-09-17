package agm_system.model;

public class Cliente {
    private int idCliente;
    private String nome;
    private String contato;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private double latitude;  
    private double longitude; 

    public Cliente() {
    }

    public Cliente(int idCliente, String nome, String contato, String logradouro, String bairro, 
                   String cidade, String estado, String pais, double latitude, double longitude) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.contato = contato;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
}