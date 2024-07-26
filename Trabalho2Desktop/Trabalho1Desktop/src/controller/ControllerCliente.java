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
import java.util.List;
import javax.swing.JOptionPane;
import java.util.stream.Collectors;

/**
 *
 * @author marin
 */
public class ControllerCliente extends Controller<Cliente>{
   private static final String NOME_ARQUIVO = "clientes.dat";

    public void criarCliente(Cliente c) throws IOException{
        criarArquivo(NOME_ARQUIVO,c);
    }
    
    public void atualizarCliente(Cliente c) throws FileNotFoundException, IOException{
        atualizarArquivo(NOME_ARQUIVO,c);
    }
    
    public void deletaCliente(String codigo) throws FileNotFoundException, IOException{
        deletarArquivo(NOME_ARQUIVO, codigo);
    }

    @Override
    public List<Cliente> retornaNovaLista(List<Cliente> os, Cliente o) throws IOException {
    os.forEach(cliente -> {
        if (cliente.getCodCli() == o.getCodCli()) {
            cliente.setTelefone(o.getTelefone());
            cliente.seteMail(o.geteMail());
            cliente.setEndereco(o.getEndereco());
        }
    });
    return super.retornaNovaLista(os, o);
    
    
    
}

    @Override
    public List<Cliente> retornaNovaListaDelete(List<Cliente> os, String codigo) throws IOException {
    os.removeIf(cliente -> String.valueOf(cliente.getCodCli()).equals(codigo));
    return super.retornaNovaListaDelete(os, codigo);
}
   
}
