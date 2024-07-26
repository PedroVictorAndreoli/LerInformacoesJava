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
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import util.JDBCUtil;

public abstract class Controller<T> {

   public String sqlinserir = "";
   public String sqlaltera = "";
   public String sqldelete = "";
   public String sqlselect = "";
   public String sqlPesquisa ="";
   public Connection connection = null;
   public PreparedStatement pstdados = null;
   public ResultSet rsdados = null;
   public static final String path = System.getProperty("user.dir");
   public static final File config_file = new File(path + "/Arquivos/configuracaibd.properties");
    
     public boolean CriaConexao() {
        try {
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);//configuracao necessaria para confirmacao ou nao de alteracoes no banco de dados.

            DatabaseMetaData dbmt = connection.getMetaData();
            System.out.println("Nome do BD: " + dbmt.getDatabaseProductName());
            System.out.println("Versao do BD: " + dbmt.getDatabaseProductVersion());
            System.out.println("URL: " + dbmt.getURL());
            System.out.println("Driver: " + dbmt.getDriverName());
            System.out.println("Versao Driver: " + dbmt.getDriverVersion());
            System.out.println("Usuario: " + dbmt.getUserName());

            return true;
        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
        }
        return false;
    }
     
     public boolean FechaConexao() {
        if (connection != null) {
            try {
                connection.close();
                return true;
            } catch (SQLException erro) {
                System.err.println("Erro ao fechar a conexão = " + erro);
                return false;
            }
        } else {
            return false;
        }
    }
     
  
   public boolean Inserir(T o)throws IOException{     
        return true;
    }
   
  public boolean Atualizar(T o)throws IOException{     
        return true;
   }
  
  public boolean Deletar(String o)throws IOException{     
        return true;
  }
  
  public List<T> BuscaTudo()throws IOException{
    List<T> listas = new ArrayList();
    return listas;
   }
  public List<T> BuscaParametro(String o)throws IOException{
    List<T> listas = new ArrayList();
    return listas;
  }
}
