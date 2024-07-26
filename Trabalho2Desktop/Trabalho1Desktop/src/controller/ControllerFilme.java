/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import classes.Cliente;
import classes.Filme;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author marin
 */
public class ControllerFilme extends Controller<Filme>{
   private static final String NOME_ARQUIVO = "filmes.dat";
    
   
   public void criarFilme(Filme v) throws IOException{
        criarArquivo(NOME_ARQUIVO,v);    
    }
    
    public void atualizarFilme(Filme v) throws FileNotFoundException, IOException{
        atualizarArquivo(NOME_ARQUIVO,v);
    } 
    
    public void deletaFilme(String titulo) throws FileNotFoundException, IOException{
        deletarArquivo(NOME_ARQUIVO, titulo);
    }

    @Override
    public List<Filme> retornaNovaListaDelete(List<Filme> os, String codigo) throws IOException {
        os.removeIf(cliente -> cliente.getTitulo().equals(codigo));
    return super.retornaNovaListaDelete(os, codigo);
    }

    @Override
    public List<Filme> retornaNovaLista(List<Filme> os, Filme o) throws IOException {
        os.forEach(cliente -> {
        if (cliente.getTitulo().equals(o.getTitulo())) {
            cliente.setPreco(o.getPreco());
        }
    });
    return super.retornaNovaLista(os, o);
    }
    
    
  

    public String[] buscaTitulos() throws FileNotFoundException, IOException{
        
        String pastainicial = System.getProperty("user.dir") + "//Arquivos//"+NOME_ARQUIVO;
        arquivo = new File(pastainicial);
        if (arquivo != null) {
            List<Filme> listaObjetos = new ArrayList<>();
            if (arquivo.exists()) {
                try (ObjectInputStream leitor = new ObjectInputStream(new FileInputStream(arquivo))) {
                    listaObjetos = (List<Filme>) leitor.readObject();
                } catch (EOFException eof) {
                    // Arquivo vazio, não faz nada
                } catch (ClassNotFoundException e) {
                    System.err.println("Erro ao ler a lista do arquivo existente: " + e.getMessage());
                }
            }
         return listaObjetos.stream()
                               .map(Filme::getTitulo)
                               .toArray(String[]::new);
          
        }
        return new String[0];
    }
}
