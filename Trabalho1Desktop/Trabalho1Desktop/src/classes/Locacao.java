/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author marin
 */
public class Locacao {
    
    private int codLocacao;
    private String dataInicio;
    private String dataFinal;
    private int codigoCliente;
    private Filme filme;
    
    public Locacao(int codLocacao, String dataInicio, String dataFinal, int codigoCliente, Filme filme) {
        this.codLocacao = codLocacao;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.codigoCliente = codigoCliente;
        this.filme = filme;
    }
    
    public Locacao() {
		
    }

    public int getCodLocacao() {
        return codLocacao;
    }

    public void setCodLocacao(int codLocacao) {
        this.codLocacao = codLocacao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    @Override
    public String toString() {
        return  codLocacao + ";" + dataInicio + ";" + dataFinal + ";" + codigoCliente + ";" + filme;
    }
    
    

}
