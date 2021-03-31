package Controller;

import java.sql.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Model.Cliente;


/**
 *
 * @author Cairo
 */
public class ClienteDAO {
    
    public void inserir(Cliente cliente) throws Exception {
        conectar c = new conectar();
        String sql = "INSERT INTO CLIENTE (NOME, CPF_CNPJ, ENDERECO) VALUES (?, ?, ?)";
        PreparedStatement ps = c.getConectar().prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf_cnpj());
        ps.execute();
 
    }


    public void alterar(Cliente cliente) throws Exception {
        conectar c = new conectar();
        String sql = "UPDATE CLIENTE SET NOME=?, CPF_CNPJ=?, ENDERECO=? WHERE IDCLIENTE=?";
        PreparedStatement ps = c.getConectar().prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf_cnpj());
        ps.setInt(4, cliente.getIdcliente());
        ps.execute();

    }


    public void excluir(Cliente cliente) throws Exception {
        conectar c = new conectar();
        String sql = "DELETE FROM CLIENTE WHERE IDCLIENTE=?";
        PreparedStatement ps = c.getConectar().prepareStatement(sql);
        ps.setInt(1, cliente.getIdcliente());
        ps.execute();
    }


    public ArrayList<Cliente> listarTodos() throws Exception {
        conectar c = new conectar();
        String sql = "SELECT * FROM CLIENTE ORDER BY NOME";
        PreparedStatement ps = c.getConectar().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaClientes = new ArrayList();
        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setIdcliente(rs.getInt("CODIGO"));
            cliente.setNome(rs.getString("NOME"));
            cliente.setCpf_cnpj(rs.getString("CPF ou CNPJ"));
            listaClientes.add(cliente);
        }

        return listaClientes;
    }


    public Cliente recuperar(int codigo) throws Exception {
        conectar c = new conectar();
        String sql = "SELECT * FROM CLIENTE WHERE CODIGO=?";
        PreparedStatement ps = c.getConectar().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Cliente cliente = new Cliente();
        if (rs.next()) {
            cliente.setIdcliente(rs.getInt("CODIGO"));
            cliente.setNome(rs.getString("NOME"));
            cliente.setCpf_cnpj(rs.getString("CPF ou CNPJ"));
        }

        return cliente;
    }
    
}
   

