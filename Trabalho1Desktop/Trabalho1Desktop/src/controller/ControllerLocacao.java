/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import classes.Locacao;
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
public class ControllerLocacao extends Controller<Locacao>{
  private static final String NOME_ARQUIVO = "locacoes.txt"; 
  
  public void criarLocacao(Locacao l) throws IOException{
        criarArquivo(NOME_ARQUIVO, l);
    }

    public void atualizarLocacao(Locacao l) throws FileNotFoundException, IOException{
        atualizarArquivo(NOME_ARQUIVO, l);
        
    }
    
    public void deletaLocacao(String codLoc) throws FileNotFoundException, IOException{ 
        deletarArquivo(NOME_ARQUIVO, codLoc);
    }
    
    @Override
    public String retornaNewLine(BufferedReader br, Locacao l) throws IOException {
        
            String line = "";
            
            String newLine = "";
            
            while ((line = br.readLine()) != null) {
                
                if(line.split(";")[0].equals(String.valueOf(l.getCodLocacao()))){
                    String[] registro  = line.split(";");
                    line = registro[0] + ";" + l.getDataInicio() + ";" + l.getDataFinal() + ";" + registro[3] + ";" + registro[4];
                }
                newLine += line + System.lineSeparator();
            }
            return newLine;
    }
}
