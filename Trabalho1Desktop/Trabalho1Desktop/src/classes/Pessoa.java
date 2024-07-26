/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author marin
 */
public abstract class Pessoa {
    
    protected String rg;
    protected String cpf;
    protected String nome;
    
    public Pessoa(String rg, String cpf, String nome){
        this.rg = rg;
        this.cpf = cpf;
        this.nome = nome;
    }
    
    public Pessoa(){
        
    }
    
}
