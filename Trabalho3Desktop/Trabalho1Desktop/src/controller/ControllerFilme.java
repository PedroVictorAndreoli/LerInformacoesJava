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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author marin
 */
public class ControllerFilme extends Controller<Filme>{
    
   
  public ControllerFilme() {
        super.sqlinserir =  "INSERT INTO filme (titulo, ano, preco) VALUES (?, ?, ?)";
        super.sqlaltera = "UPDATE filme SET preco = ? WHERE titulo = ?";
        super.sqldelete = "DELETE FROM filme WHERE titulo = ?";
        super.sqlselect = "SELECT titulo,ano,preco FROM filme";
        super.sqlPesquisa = "SELECT titulo,ano,preco FROM filme where titulo = ?";
    }

    @Override
    public boolean Inserir(Filme o) throws IOException {
         try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            pstdados = connection.prepareStatement(sqlinserir, tipo, concorrencia);
            pstdados.setString(1, o.getTitulo());
            pstdados.setInt(2, o.getAno());
            pstdados.setDouble(3, o.getPreco());
            int resposta = pstdados.executeUpdate();
            
            // DEBUG
            System.out.println("Resposta da inserção = " + resposta);
            // FIM-DEBUG

            if (resposta == 1) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
                return false;
            }
        } catch (SQLException erro) {
            System.out.println("Erro na execução da inserção = " + erro);
        }
        return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public boolean Atualizar(Filme o) throws IOException {
        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            pstdados = connection.prepareStatement(sqlaltera, tipo, concorrencia);
            pstdados.setDouble(1, o.getPreco());
            pstdados.setString(2, o.getTitulo());
            int resposta = pstdados.executeUpdate();
            pstdados.close();
            //DEBUG
            System.out.println("Resposta da atualização = " + resposta);
            //FIM-DEBUG
            if (resposta == 1) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
                return false;
            }
        } catch (SQLException erro) {
            System.out.println("Erro na execução da atualização = " + erro);
        }
        return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public boolean Deletar(String o) throws IOException {
       try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            pstdados = connection.prepareStatement(sqldelete, tipo, concorrencia);
            pstdados.setString(1, o);
            int resposta = pstdados.executeUpdate();
            pstdados.close();
            //DEBUG
            System.out.println("Resposta da exclusão = " + resposta);
            //FIM-DEBUG
            if (resposta == 1) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
                return false;
            }
        } catch (SQLException erro) {
            System.out.println("Erro na execução da exclusão = " + erro);
        }
        return false;
    }

    @Override
    public List<Filme> BuscaTudo() throws IOException {
        List<Filme> listas = new ArrayList<>();
        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            pstdados = connection.prepareStatement(sqlselect, tipo, concorrencia);
            ResultSet rs = pstdados.executeQuery();

            while (rs.next()) {
                String titulo = rs.getString("TITULO");
                int ano = rs.getInt("ANO");
                Double preco = rs.getDouble("PRECO");
                Filme cliente = new Filme( titulo, ano, preco);
                listas.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pstdados != null) pstdados.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listas; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    public String[] buscaTitulos() throws FileNotFoundException, IOException{
        List<String> listaTitulos = new ArrayList<>();
    try {
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_UPDATABLE;
        pstdados = connection.prepareStatement(sqlselect, tipo, concorrencia);
        ResultSet rs = pstdados.executeQuery();

        while (rs.next()) {
            String titulo = rs.getString("TITULO");
            listaTitulos.add(titulo);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstdados != null) pstdados.close();
            if (connection != null) connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    String[] resultadoArray = new String[listaTitulos.size()];
    resultadoArray = listaTitulos.toArray(resultadoArray);
    return resultadoArray;
    }

    @Override
    public List<Filme> BuscaParametro(String o) throws IOException {
        List<Filme> listas = new ArrayList<>();
        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            pstdados = connection.prepareStatement(sqlPesquisa, tipo, concorrencia);
            pstdados.setString(1, o);
            ResultSet rs = pstdados.executeQuery();

            while (rs.next()) {
                String titulo = rs.getString("TITULO");
                int ano = rs.getInt("ANO");
                Double preco = rs.getDouble("PRECO");
                Filme cliente = new Filme( titulo, ano, preco);
                listas.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pstdados != null) pstdados.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listas;
    }
    
    
    
}
