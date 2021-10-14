package br.com.residencia.bankend.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.residencia.bankend.clientes.Cliente;
import br.com.residencia.bankend.funcionarios.Diretor;
import br.com.residencia.bankend.funcionarios.Funcionario;
import br.com.residencia.bankend.funcionarios.Gerente;
import br.com.residencia.bankend.funcionarios.Presidente;

public class Query {
	private Connection conexao = null;
	private PreparedStatement st = null;
	private ResultSet rs = null;

	public Query(Connection conexao) {

		this.conexao = conexao;
	}

	public Funcionario verifica(String login, String senha, Cliente clientes) {

			Funcionario fun=null;
		int idAdmin = 0;

		// pega o login e a senha do admin
		try {
			st = conexao.prepareStatement("select * from admin where login = ? and senha =? ");
			st.setString(1, login);
			st.setString(2, senha);
			st.execute();

			rs = st.getResultSet();

			// pega a chave primaria do admin

			if (rs.next()) {
				idAdmin = rs.getInt("IdAdmin");

			} else {
				System.out.println("NAO EXISTE");
			}

			// chama o metodo que verifica o cliente
			
			
			verificaFuncionario(idAdmin,fun);
			

		} catch (Exception e) {

		}
		
		return fun;

	}

	public void verificaCliente(int idAdmin, Cliente cliente, Funcionario funcionario)

	{

		try {
			st = conexao.prepareStatement("select *from cliente where id_admin = ?");

			st.setInt(1, idAdmin);

			st.execute();

			rs = st.getResultSet();

			if (rs.next()) {

				// PEGANDO VALORES DO BANCO
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String email = rs.getString("email");
				String cpf = rs.getString("cpf");
				String senha = rs.getString("senha");

				// Passando os valores para o objeto cliente
				cliente.trocaCliente(nome, sobrenome, email, cpf, senha);

			}

			else {
				verificaFuncionario(idAdmin, funcionario);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void verificaFuncionario(int id, Funcionario fun) {

		try {
			st = conexao.prepareStatement("select *from funcionario where id_admin = ?");

			st.setInt(1, id);

			st.execute();

			rs = st.getResultSet();

			if (rs.next()) {

				// pegando os valores do banco
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String email = rs.getString("email");
				String cpf = rs.getString("cpf");
				String senha = rs.getString("senha");
				String cargo = rs.getString("cargo");
				double salario = rs.getFloat("salario");
				int acesso = rs.getInt("acesso");
				int agencia=0;
				
				switch (acesso) {
				case 1:
					Gerente gerente = new Gerente(nome, sobrenome, cargo, cpf, email, senha, salario, acesso, agencia);
					fun=gerente;
					
					break;
				case 2:
					Diretor diretor = new Diretor(nome, sobrenome, cargo, cpf, email, senha, salario, acesso, null);
					
					fun=diretor;
					
					break;
				case 3:
					Presidente presidente = new Presidente(nome, sobrenome, cargo, cpf, email, senha, salario, acesso);
					
					fun=presidente;

					
					break;

				}

			}

			else {
				JOptionPane.showMessageDialog(null, "FODEU CARALHO");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}