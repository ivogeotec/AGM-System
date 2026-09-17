package agm_system.model;

public class LocalObra {
    private int idLocalObra;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private double latitude;
    private double longitude;
    private int idCliente; 

    public LocalObra() {
    }

    public LocalObra(int idLocalObra, String logradouro, String bairro, String cidade, 
                     String estado, double latitude, double longitude, int idCliente) {
        this.idLocalObra = idLocalObra;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.latitude = latitude;
        this.longitude = longitude;
        this.idCliente = idCliente;
    }

    public int getIdLocalObra() { return idLocalObra; }
    public void setIdLocalObra(int idLocalObra) { this.idLocalObra = idLocalObra; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
}