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

	public Funcionario funcionario(String emaill, String senhaa) {
		Funcionario fun = null;
		try {
			st = conexao.prepareStatement("select * from funcionario where email = ? and senha =? ");
			st.setString(1, emaill);
			st.setString(2, senhaa);
			st.execute();

			rs = st.getResultSet();

			if (rs.next()) {

				String nome = rs.getString("nome");
				String sobreNome = rs.getString("sobrenome");
				String cargo = rs.getString("cargo");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				int acesso = rs.getInt("acesso");
				double salario = rs.getDouble("salario");

				switch (acesso) {
				case 1:
					fun = new Gerente(nome, sobreNome, cargo, cpf, email, senha, salario, acesso, null);

					break;
				case 2:
					fun = new Diretor(nome, sobreNome, cargo, cpf, email, senha, salario, acesso, null);

					break;
				case 3:
					fun = new Presidente(nome, sobreNome, cargo, cpf, email, senha, salario, acesso);
					break;

				}

			} else {
				System.out.println("nao existe  funcionario");
			}

		} catch (Exception e) {

		}
		return fun;
	}

	public Cliente cliente(String emaill, String senhaa) {

		Cliente cliente = null;
		{

			try {

				st = conexao.prepareStatement("select * from cliente where email = ? and senha =? ");
				st.setString(1, emaill);
				st.setString(2, senhaa);
				st.execute();

				st.execute();

				rs = st.getResultSet();

				if (rs.next()) {

					String nome = rs.getString("nome");
					String sobrenome = rs.getString("sobrenome");
					String email = rs.getString("email");
					String cpf = rs.getString("cpf");
					String senha = rs.getString("senha");

					cliente = new Cliente(nome, sobrenome, email, cpf, senha);

					return cliente;
				}

				else {
					System.out.println("cliente n encontrado");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return cliente;
		}

	}

}