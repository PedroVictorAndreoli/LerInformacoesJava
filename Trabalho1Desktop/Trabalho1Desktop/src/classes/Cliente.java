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
public class Cliente extends Pessoa implements Serializable {
    
    private int codCli;
    private String telefone;
    private String endereco;
    private String eMail;
    
    private static final long serialVersionUID = -4395647541021886002L;
    
    public Cliente(String rg, String cpf, String nome, int codCli, String telefone, String endereco, String eMail) {
            super(rg, cpf, nome);
            this.codCli = codCli;
            this.telefone = telefone;
            this.endereco = endereco;
            this.eMail = eMail;
    }
    
    public Cliente(){
        
    }

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return  codCli + ";"+ super.nome +";"+super.rg+ ";" + super.cpf+ ";" + telefone + ";" + endereco + ";" + eMail;
    }
    
    
    
}

