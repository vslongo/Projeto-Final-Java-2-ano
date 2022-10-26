package br.edu.ifcvideira.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifcvideira.beans.Cliente;
import br.edu.ifcvideira.utils.Conexao;

public class ClienteDao{
	
	public void CadastrarCliente(Cliente cl) throws SQLException, Exception{
		try{
			String sql = "INSERT INTO cliente (nome, cpf, telefone, renda, idade, filhos, data, periodo) VALUES (?,?,?,?,?,?,?,?)";
			java.sql.PreparedStatement sqlPrep = Conexao.conectar().prepareStatement(sql);
			sqlPrep.setString(1, cl.getNome());
			sqlPrep.setString(2, cl.getCpf());
			sqlPrep.setString(3, cl.getTelefone());
			sqlPrep.setDouble(4, cl.getRenda());
			sqlPrep.setInt(5, cl.getIdade());
			sqlPrep.setInt(6, cl.getFilhos());
			sqlPrep.setTimestamp(7, cl.getData());
			sqlPrep.setString(8, cl.getPeriodo());
			sqlPrep.execute();
			
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}

	public void AlterarCliente(Cliente cl) throws Exception {
		try{
			String sql = "UPDATE cliente SET nome=?, cpf=?, telefone=?, renda=?, idade=?, filhos=?, data=?, periodo=? WHERE codigo=?";
			PreparedStatement sqlPrep = Conexao.conectar().prepareStatement(sql);
			sqlPrep.setString(1, cl.getNome());
			sqlPrep.setString(2, cl.getCpf());
			sqlPrep.setString(3, cl.getTelefone());
			sqlPrep.setDouble(4, cl.getRenda());
			sqlPrep.setInt(5, cl.getIdade());
			sqlPrep.setInt(6, cl.getFilhos());
			sqlPrep.setTimestamp(7, cl.getData());
			sqlPrep.setString(8, cl.getPeriodo());
			sqlPrep.setInt(9, cl.getCodigo());
			sqlPrep.execute();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void deletarCliente(Cliente cl) throws Exception{
		try{
			String sql = "DELETE FROM cliente WHERE codigo=? ";
			PreparedStatement sqlPrep = (PreparedStatement) Conexao.conectar().prepareStatement(sql);
			sqlPrep.setInt(1, cl.getCodigo());
			sqlPrep.execute();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public List<Object> buscarTodos() throws SQLException, Exception{
		List<Object> cliente = new ArrayList<Object>();
		try {
			String sql = "SELECT * FROM cliente";
			java.sql.Statement state = Conexao.conectar().createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next())
			{
				Object[] linha = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)};
				cliente.add(linha);
			}
			state.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return cliente;
	}
	
	public int RetornarProximoCodigoCliente() throws Exception {
		try{
			String sql ="SELECT MAX(codigo)+1 AS codigo FROM cliente ";
			PreparedStatement sqlPrep = Conexao.conectar().prepareStatement(sql);
			ResultSet rs = sqlPrep.executeQuery();
			if (rs.next()){
				return rs.getInt("codigo");
			}else{
				return 1;
			}
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return 1;
		}
	}
}