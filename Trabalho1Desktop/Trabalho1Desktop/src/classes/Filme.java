/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author marin
 */
public class Filme {
    
    private String titulo;
    private int ano;
    private Double preco;
    
    public Filme(String titulo, int ano, Double preco) {
        this.titulo = titulo;
        this.ano = ano;
        this.preco = preco;
    }
    
    public Filme() {
		
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return titulo + ";" + ano + ";" + preco ;
    }
    
}
