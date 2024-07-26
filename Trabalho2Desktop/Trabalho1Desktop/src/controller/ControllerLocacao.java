/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import classes.Filme;
import classes.Locacao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author marin
 */
public class ControllerLocacao extends Controller<Locacao>{
  private static final String NOME_ARQUIVO = "locacoes.dat"; 
  
  public void criarLocacao(Locacao l) throws IOException{
        criarArquivo(NOME_ARQUIVO,l);
    }

    public void atualizarLocacao(Locacao l) throws FileNotFoundException, IOException{
        atualizarArquivo(NOME_ARQUIVO,l);
    }
    
    public void deletaLocacao(String codLoc) throws FileNotFoundException, IOException{ 
        deletarArquivo(NOME_ARQUIVO, codLoc);
    }

    @Override
    public List<Locacao> retornaNovaListaDelete(List<Locacao> os, String codigo) throws IOException {
        os.removeIf(cliente -> String.valueOf(cliente.getCodLocacao()).equals(codigo));
    return super.retornaNovaListaDelete(os, codigo);
    }

    @Override
    public List<Locacao> retornaNovaLista(List<Locacao> os, Locacao o) throws IOException {
        os.forEach(cliente -> {
        if (cliente.getCodLocacao() == o.getCodLocacao()) {
            cliente.setDataInicio(o.getDataInicio());
            cliente.setDataFinal(o.getDataFinal());
        }
    });
    return super.retornaNovaLista(os, o);
    }
    
    
    
}
