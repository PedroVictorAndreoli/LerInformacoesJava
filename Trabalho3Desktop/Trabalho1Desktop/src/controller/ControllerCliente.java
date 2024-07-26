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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.stream.Collectors;

/**
 *
 * @author marin
 */
public class ControllerCliente extends Controller<Cliente>{

    public ControllerCliente() {
        super.sqlinserir =  "INSERT INTO cliente (id_pessoa, telefone, email, endereco,id) VALUES (?, ?, ?, ?, ?)";
        super.sqlaltera = "UPDATE cliente SET telefone = ?, endereco = ?, email = ? WHERE id = ?";
        super.sqldelete = "DELETE FROM cliente WHERE id = ?";
        super.sqlselect = "SELECT CLIENTE_ID,RG,CPF,NOME,TELEFONE,EMAIL,ENDERECO FROM PESSOA_CLIENTE";
        super.sqlPesquisa = "SELECT CLIENTE_ID,RG,CPF,NOME,TELEFONE,EMAIL,ENDERECO FROM PESSOA_CLIENTE where CLIENTE_ID = ?";
    }

    @Override
    public boolean Inserir(Cliente o) throws IOException {
          try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            String sqlPessoa = "SELECT id FROM pessoa where cpf= ?";
            String sqlinsertPessoa = "INSERT INTO pessoa(nome,cpf,rg) values(?,?,?)";
            pstdados = connection.prepareStatement(sqlinsertPessoa, tipo, concorrencia);
            pstdados.setString(1, o.getNome());
            pstdados.setString(2, o.getCpf());
            pstdados.setString(3, o.getRg());
            int resposta = pstdados.executeUpdate();
            //DEBUG
            System.out.println("Resposta da inserção = " + resposta);
            //FIM-DEBUG
            if (resposta == 1) {
                connection.commit();
            } else {
                connection.rollback();
            }
            pstdados = connection.prepareStatement(sqlPessoa, tipo, concorrencia);
            
            
            pstdados.setString(1, o.getCpf());
            ResultSet rs = pstdados.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            
            pstdados = connection.prepareStatement(sqlinserir, tipo, concorrencia);
            pstdados.setInt(1, id);
            pstdados.setString(2, o.getTelefone());
            pstdados.setString(3, o.geteMail());
            pstdados.setString(4, o.getEndereco());
            pstdados.setInt(5, o.getCodCli());
            resposta = pstdados.executeUpdate();
            pstdados.close();
            //DEBUG
            System.out.println("Resposta da inserção = " + resposta);
            //FIM-DEBUG
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
        return false;
    }

    @Override
    public boolean Atualizar(Cliente o) throws IOException {
        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            pstdados = connection.prepareStatement(sqlaltera, tipo, concorrencia);
            pstdados.setString(1, o.getTelefone());
            pstdados.setString(2, o.getEndereco());
            pstdados.setString(3, o.geteMail());
            pstdados.setInt(4, o.getCodCli());
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
        return false;
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
        return false;
    }

    @Override
    public List<Cliente> BuscaTudo()  throws IOException{
        List<Cliente> listas = new ArrayList<>();
        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            pstdados = connection.prepareStatement(sqlselect, tipo, concorrencia);
            ResultSet rs = pstdados.executeQuery();

            while (rs.next()) {
                int clienteId = rs.getInt("CLIENTE_ID");
                String rg = rs.getString("RG");
                String cpf = rs.getString("CPF");
                String nome = rs.getString("NOME");
                String telefone = rs.getString("TELEFONE");
                String email = rs.getString("EMAIL");
                String endereco = rs.getString("ENDERECO");
                Cliente cliente = new Cliente( rg, cpf, nome,clienteId, telefone, endereco, email);
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

    @Override
    public List<Cliente> BuscaParametro(String o) throws IOException {
        List<Cliente> listas = new ArrayList<>();
        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            pstdados = connection.prepareStatement(sqlPesquisa, tipo, concorrencia);
            pstdados.setInt(1, Integer.parseInt(o));
            ResultSet rs = pstdados.executeQuery();

            while (rs.next()) {
                int clienteId = rs.getInt("CLIENTE_ID");
                String rg = rs.getString("RG");
                String cpf = rs.getString("CPF");
                String nome = rs.getString("NOME");
                String telefone = rs.getString("TELEFONE");
                String email = rs.getString("EMAIL");
                String endereco = rs.getString("ENDERECO");
                Cliente cliente = new Cliente( rg, cpf, nome,clienteId, telefone, endereco, email);
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
