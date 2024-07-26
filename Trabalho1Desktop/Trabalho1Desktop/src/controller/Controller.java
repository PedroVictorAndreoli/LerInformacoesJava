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
 * @author Pedro
 */
public abstract class Controller<T> {
    
   public void criarArquivo(String nomeArquivo, T o)throws IOException{

        try {
            
            File arquivoCliente = new File(System.getProperty("user.dir")+"\\Arquivos\\"+ nomeArquivo);
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoCliente, true));
            
            writer.write(o.toString() + System.lineSeparator());
            writer.close();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Operação Concluída", JOptionPane.INFORMATION_MESSAGE);
        
        } catch (Exception e){
            
            JOptionPane.showMessageDialog(null, "Erro na comunicação com o arquivo de dados!", "Falha Encontrada", JOptionPane.OK_OPTION);
            e.printStackTrace();
            
        }

    }
   
   public String retornaNewLine(BufferedReader br, T o) throws IOException{
            String newLine = "";
            return newLine;
   }
     public String retornaNewLineDelete(BufferedReader br, String codigo) throws IOException{
           
         
            String line = "";
            
            String newLine = "";
            
            while ((line = br.readLine()) != null) {
                
                if(!line.split(";")[0].equals(codigo))
                    newLine += line + System.lineSeparator();
            }
            return newLine;
   }
   
   
   
   
   public void atualizarArquivo(String nomeArquivo, T o)throws FileNotFoundException, IOException{
        
        File arquivoCliente = new File(System.getProperty("user.dir")+"\\Arquivos\\"+ nomeArquivo);
        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCliente))) {
            
            String newLine = retornaNewLine(br, o);
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoCliente, true));
          
            PrintWriter pw = new PrintWriter(arquivoCliente);
            pw.close();
            
            writer.write(newLine);
            
            writer.close();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!", "Operação Concluída", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
    }
   
   public void deletarArquivo(String nomeArquivo,String codigo)throws FileNotFoundException, IOException{
        
        File arquivoCliente = new File(System.getProperty("user.dir")+"\\Arquivos\\"+ nomeArquivo);
        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCliente))) {
        
            
            String newLine = retornaNewLineDelete(br, codigo);
            
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoCliente, true));
          
            PrintWriter pw = new PrintWriter(arquivoCliente);
            pw.close();
            
            writer.write(newLine);
            
            writer.close();

            JOptionPane.showMessageDialog(null, "Deletado com sucesso!", "Operação Concluída", JOptionPane.INFORMATION_MESSAGE);
            
        }        
    }
}
