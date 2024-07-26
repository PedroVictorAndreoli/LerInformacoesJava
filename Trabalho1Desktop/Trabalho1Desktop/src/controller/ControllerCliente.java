/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import classes.Cliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author marin
 */
public class ControllerCliente extends Controller<Cliente>{
   private static final String NOME_ARQUIVO = "clientes.txt";

    public void criarCliente(Cliente c) throws IOException{
        criarArquivo(NOME_ARQUIVO, c);
    }
    
    public void atualizarCliente(Cliente c) throws FileNotFoundException, IOException{
        atualizarArquivo(NOME_ARQUIVO, c);
    }
    
    public void deletaCliente(String codigo) throws FileNotFoundException, IOException{
        deletarArquivo(NOME_ARQUIVO, codigo);
    }
    
    @Override
    public String retornaNewLine(BufferedReader br, Cliente c) throws IOException {
            String line = "";
            
            String newLine = "";
            
            while ((line = br.readLine()) != null) {
                
                if(line.split(";")[0].equals(String.valueOf(c.getCodCli()))){
                    String[] registro  = line.split(";");
                    line = registro[0] + ";" + registro[1] + ";" + registro[2] + ";" + registro[3] + ";" + c.getTelefone() + ";" + c.getEndereco() + ";" + c.geteMail();
                }
                newLine += line + System.lineSeparator();
            }
        return newLine; 
    }
}
