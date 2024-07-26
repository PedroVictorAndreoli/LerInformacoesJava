/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.Serializable;

/**
 *
 * @author marin
 */
public abstract class Pessoa implements Serializable{
    private static final long serialVersionUID = 1L;
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
