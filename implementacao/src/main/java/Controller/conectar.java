/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.*;


/**
 *
 * @author Cairo
 */
public class conectar {
    
    private final String SERVIDOR = "localhost";
    private final String PORTA = "3306";
    private final String BANCO_DE_DADOS = "mateus_vendas";
    private final String USUARIO = "root";
    private final String SENHA = "DTB619354";
    private final String PATH = "jdbc:mysql://" + SERVIDOR + ":" + PORTA + "/" + BANCO_DE_DADOS;

    private Connection conectar;
    
     public conectar() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conectar = DriverManager.getConnection(PATH, USUARIO, SENHA);
            conectar.setAutoCommit(false);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new ClassNotFoundException("não há driver de conexão.\n" + e.getMessage());
        } catch (SQLException e) {
            throw new SQLException("Problema na conexão.\n" + e.getMessage());
        }
    }
     
      public Connection  getConectar() {
        return conectar;
    }
}
