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
public class ControllerLocacao extends Controller<Locacao>{
  private static final String NOME_ARQUIVO = "locacoes.dat"; 
  
  public ControllerLocacao() {
        super.sqlinserir =  "INSERT INTO locacao (id,dataInicio,dataFinal,id_cliente, titulo) VALUES (?, ?, ?, ?, ?)";
        super.sqlaltera = "UPDATE locacao SET dataInicio  = ?,dataFinal = ? WHERE id = ?";
        super.sqldelete = "DELETE FROM locacao WHERE id = ?";
        super.sqlselect = "SELECT id,dataInicio,dataFinal,id_cliente, titulo FROM locacao";
        super.sqlPesquisa = "SELECT id,dataInicio,dataFinal,id_cliente, titulo FROM locacao where id = ?";
    }

    @Override
    public boolean Inserir(Locacao o) throws IOException {
         try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            pstdados = connection.prepareStatement(sqlinserir, tipo, concorrencia);
            pstdados.setInt(1, o.getCodLocacao());
            pstdados.setString(2, o.getDataInicio());
            pstdados.setString(3, o.getDataFinal());
            pstdados.setInt(4, o.getCodigoCliente());
            pstdados.setString(5, o.getFilme().getTitulo());
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
        return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

  
  
    @Override
    public boolean Atualizar(Locacao o) throws IOException {
         try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            pstdados = connection.prepareStatement(sqlaltera, tipo, concorrencia);
            pstdados.setString(1, o.getDataInicio());
            pstdados.setString(2, o.getDataFinal());
            pstdados.setInt(3, o.getCodLocacao());
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
        return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public boolean Deletar(String o) throws IOException {
        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            pstdados = connection.prepareStatement(sqldelete, tipo, concorrencia);
            pstdados.setInt(1, Integer.parseInt(o));
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
        return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public List<Locacao> BuscaTudo() throws IOException {
        List<Locacao> listas = new ArrayList<>();
        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            pstdados = connection.prepareStatement(sqlselect, tipo, concorrencia);
            ResultSet rs = pstdados.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String dataInicio = rs.getString("DATAINICIO");
                String dataFinal = rs.getString("DATAFINAL");
                int id_cliente = rs.getInt("ID_CLIENTE");
                String titulo = rs.getString("TITULO");
                Filme filme = new Filme();
                filme.setTitulo(titulo);
                Locacao cliente = new Locacao( id, dataInicio, dataFinal,id_cliente,filme);
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

    @Override
    public List<Locacao> BuscaParametro(String o) throws IOException {
         List<Locacao> listas = new ArrayList<>();
        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            pstdados = connection.prepareStatement(sqlPesquisa, tipo, concorrencia);
            pstdados.setInt(1, Integer.parseInt(o));
            ResultSet rs = pstdados.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String dataInicio = rs.getString("DATAINICIO");
                String dataFinal = rs.getString("DATAFINAL");
                int id_cliente = rs.getInt("ID_CLIENTE");
                String titulo = rs.getString("TITULO");
                Filme filme = new Filme();
                filme.setTitulo(titulo);
                Locacao cliente = new Locacao( id, dataInicio, dataFinal,id_cliente,filme);
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
