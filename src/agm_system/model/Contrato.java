package agm_system.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
    private int idContrato;
    private String dataInicio;
    private String dataFim;
    private String status;
    private double valorTotal;
    
    private Cliente cliente;
    private LocalObra localObra;
    private List<Equipamento> itens; 

    public Contrato() {
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public Contrato(int idContrato, String dataInicio, String dataFim, String status, Cliente cliente, LocalObra localObra) {
        this.idContrato = idContrato;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
        this.cliente = cliente;
        this.localObra = localObra;
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }
    
  
    public void adicionarEquipamento(Equipamento eq) {
        this.itens.add(eq);
        recalcularTotalPorHoras();
    }

   
    public void recalcularTotalPorHoras() {
        if (dataInicio == null || dataFim == null || itens.isEmpty()) {
            this.valorTotal = 0.0;
            return;
        }

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            Date inicio = formatador.parse(dataInicio);
            Date fim = formatador.parse(dataFim);

            long diferencaMilissegundos = fim.getTime() - inicio.getTime();
            
            if (diferencaMilissegundos <= 0) {
                this.valorTotal = 0.0;
                return;
            }

            double horasTotais = diferencaMilissegundos / (1000.0 * 60.0 * 60.0);

            double somaDiarias = 0.0;
            for (Equipamento eq : itens) {
                somaDiarias += eq.getValorDiaria();
            }

            double valorPorHora = somaDiarias / 24.0;

            this.valorTotal = horasTotais * valorPorHora;

        } catch (ParseException e) {
            this.valorTotal = 0.0; 
        }
    }

    public int getIdContrato() { return idContrato; }
    public void setIdContrato(int idContrato) { this.idContrato = idContrato; }

    public String getDataInicio() { return dataInicio; }
    public void setDataInicio(String dataInicio) { 
        this.dataInicio = dataInicio; 
        recalcularTotalPorHoras(); 
    }

    public String getDataFim() { return dataFim; }
    public void setDataFim(String dataFim) { 
        this.dataFim = dataFim; 
        recalcularTotalPorHoras(); 
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public LocalObra getLocalObra() { return localObra; }
    public void setLocalObra(LocalObra localObra) { this.localObra = localObra; }

    public List<Equipamento> getItens() { return itens; }
    public void setItens(List<Equipamento> itens) { this.itens = itens; }
}