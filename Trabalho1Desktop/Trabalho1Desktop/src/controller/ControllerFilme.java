/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import classes.Cliente;
import classes.Filme;
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
public class ControllerFilme extends Controller<Filme>{
   private static final String NOME_ARQUIVO = "filmes.txt";
    
   
   public void criarFilme(Filme v) throws IOException{
        criarArquivo(NOME_ARQUIVO, v);    
    }
    
    public void atualizarFilme(Filme v) throws FileNotFoundException, IOException{
        atualizarArquivo(NOME_ARQUIVO, v);
    } 
    
    public void deletaFilme(String titulo) throws FileNotFoundException, IOException{
        deletarArquivo(NOME_ARQUIVO, titulo);
    }
    
    
    @Override
    public String retornaNewLine(BufferedReader br,Filme v) throws IOException {
            String line = "";       
            String newLine = "";
            
            while ((line = br.readLine()) != null) {
                
                if(line.split(";")[0].equals(String.valueOf(v.getTitulo()))){
                    String[] registro  = line.split(";");
                    line = registro[0] + ";" + registro[1] + ";" + v.getPreco();
                }
                newLine += line + System.lineSeparator();
            } 
            return newLine; 
    }

    public String[] buscaTitulos() throws FileNotFoundException, IOException{
        
        File arquivoFilme = new File(System.getProperty("user.dir")+"\\Arquivos\\filmes.txt");       
        
        String titulos = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoFilme))) {
        
            String line = "";
            
            while ((line = br.readLine()) != null) {
                
                if(!line.equals("Titulo,Ano,Valor / Dia"))
                    titulos += line.split(";")[0] + System.lineSeparator();
            }
            
        }
        
        return titulos.split(System.lineSeparator());
    }
}
