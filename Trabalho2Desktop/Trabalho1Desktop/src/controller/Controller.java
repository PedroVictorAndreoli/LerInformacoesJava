/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import classes.Cliente;
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
import java.util.stream.Stream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro
 */
public abstract class Controller<T> {
   private ObjectOutputStream escritor = null;
   protected File arquivo = null;
   private ObjectInputStream leitor = null;
   
   public boolean criarArquivo(String nomeArquivo,T o)throws IOException{     
        String pastainicial = System.getProperty("user.dir") + "//Arquivos//"+nomeArquivo;
        arquivo = new File(pastainicial);
        if (arquivo != null) {
            List<T> listaObjetos = new ArrayList<>();
            if (arquivo.exists()) {
                try (ObjectInputStream leitor = new ObjectInputStream(new FileInputStream(arquivo))) {
                    listaObjetos = (List<T>) leitor.readObject();
                } catch (EOFException eof) {
                    // Arquivo vazio, não faz nada
                } catch (ClassNotFoundException e) {
                    System.err.println("Erro ao ler a lista do arquivo existente: " + e.getMessage());
                    return false;
                }
            }
            
            listaObjetos.add(o);
            listaObjetos.forEach((t) -> {
                System.out.println(t);
            });
            try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(arquivo, false))) {
                escritor.writeObject(listaObjetos);
                return true;
            } catch (IOException erro) {
                System.err.println(erro.getMessage() + " Erro ao escrever no arquivo binário.");
                return false;
            }
        } else {
            return false;
        }
    }
   
  
   
   
   
   
   public boolean atualizarArquivo(String nomeArquivo,T o)throws FileNotFoundException, IOException{
        String pastainicial = System.getProperty("user.dir") + "//Arquivos//"+nomeArquivo;
        arquivo = new File(pastainicial);
        if (arquivo != null) {
            List<T> listaObjetos = new ArrayList<>();
            List<T> listaObjetosNovo = new ArrayList<>();
            if (arquivo.exists()) {
                try (ObjectInputStream leitor = new ObjectInputStream(new FileInputStream(arquivo))) {
                    listaObjetos = (List<T>) leitor.readObject();
                } catch (EOFException eof) {
                    // Arquivo vazio, não faz nada
                } catch (ClassNotFoundException e) {
                    System.err.println("Erro ao ler a lista do arquivo existente: " + e.getMessage());
                    return false;
                }
            }
            listaObjetosNovo = retornaNovaLista(listaObjetos, o);
            try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(arquivo, false))) {
                escritor.writeObject(listaObjetosNovo);
                return true;
            } catch (IOException erro) {
                System.err.println(erro.getMessage() + " Erro ao escrever no arquivo binário.");
                return false;
            }
        } else {
            return false;
        }
    }
   
   public boolean deletarArquivo(String nomeArquivo,String codigo)throws FileNotFoundException, IOException{
        
        String pastainicial = System.getProperty("user.dir") + "//Arquivos//"+nomeArquivo;
        arquivo = new File(pastainicial);
        if (arquivo != null) {
            List<T> listaObjetos = new ArrayList<>();
            List<T> listaObjetosNovo = new ArrayList<>();
            if (arquivo.exists()) {
                try (ObjectInputStream leitor = new ObjectInputStream(new FileInputStream(arquivo))) {
                    listaObjetos = (List<T>) leitor.readObject();
                } catch (EOFException eof) {
                    // Arquivo vazio, não faz nada
                } catch (ClassNotFoundException e) {
                    System.err.println("Erro ao ler a lista do arquivo existente: " + e.getMessage());
                    return false;
                }
            }
            listaObjetosNovo = retornaNovaListaDelete(listaObjetos, codigo);
            try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(arquivo, false))) {
                escritor.writeObject(listaObjetosNovo);
                return true;
            } catch (IOException erro) {
                System.err.println(erro.getMessage() + " Erro ao escrever no arquivo binário.");
                return false;
            }
        } else {
            return false;
        }
    }
   
    public List<T> retornaNovaLista(List<T> os, T o) throws IOException{
            return os;
   }
     public List<T> retornaNovaListaDelete(List<T> os, String codigo) throws IOException{
           return os;
   }
}
