package br.com.residencia.bankend.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.residencia.bankend.clientes.Cliente;
import br.com.residencia.bankend.contas.ContaCorrente;
import br.com.residencia.bankend.contas.ContaPoupanca;
import br.com.residencia.bankend.contas.Contas;
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
					int id = rs.getInt("IdCliente");
					String nome = rs.getString("nome");
					String sobrenome = rs.getString("sobrenome");
					String email = rs.getString("email");
					String cpf = rs.getString("cpf");
					String senha = rs.getString("senha");

					cliente = new Cliente(nome, sobrenome, email, cpf, senha, id);

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

	public Contas descobreConta(Cliente cliente) {

		Contas continha = null;

		try {
			st = conexao.prepareStatement("select * from contas,cliente where id_cliente=?");

			st.setInt(1, cliente.getId());
			st.execute();

			rs = st.getResultSet();

			if (rs.next()) {
				String numero = rs.getString("numero");
				double saldo = rs.getFloat("saldo");
				String tipo = rs.getString("tipo");
				String agencia = rs.getString("agencia");
				int IdConta = rs.getInt("IdConta");

				if (tipo.equals("corrente")) {
					ContaCorrente corrente = new ContaCorrente(agencia, numero, tipo, saldo, cliente, null, IdConta);
					continha = corrente;
				} else {
					ContaPoupanca poupanca = new ContaPoupanca(agencia, numero, tipo, saldo, cliente, null, IdConta);
					continha = poupanca;
				}

			}

			return continha;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return continha;
	}

	public Contas verificaConta(String conta) {

		Contas continha = null;

		try {

			st = conexao.prepareStatement("select *from contas where numero = ?  ");

			st.setString(1, conta);

			st.execute();

			rs = st.getResultSet();

			if (rs.next()) {
				int idConta = rs.getInt("IDConta");
				String numero = rs.getString("numero");
				double saldo = rs.getDouble("saldo");
				String tipo = rs.getString("tipo");
				String agencia = rs.getString("agencia");

				if (tipo.equals("corrente")) {
					Cliente cliente = descobreCliente(idConta);
					ContaCorrente corrente = new ContaCorrente(agencia, numero, tipo, saldo, cliente, null, idConta);

					continha = corrente;
				}

				if (tipo.equals("poupanca")) {
					Cliente cliente = descobreCliente(idConta);

					ContaPoupanca poupanca = new ContaPoupanca(agencia, numero, tipo, saldo, cliente, null, idConta);
					continha = poupanca;

				}

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return continha;

	}

	public Cliente descobreCliente(int id) {

		Cliente clientee = null;

		try {
			st = conexao.prepareStatement("Select *from cliente where idCliente = ?");

			st.setInt(1, id);

			st.execute();

			rs = st.getResultSet();

			if (rs.next()) {
				int idCliente = rs.getInt("IdCliente");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String email = rs.getString("email");
				String cpf = rs.getString("cpf");
				String senha = rs.getString("senha");

				Cliente cliente = new Cliente(nome, sobrenome, email, cpf, senha, idCliente);
				clientee = cliente;
			}

		} catch (SQLException e) {
			System.out.println("DEU MERDA");
			e.printStackTrace();
		}
		return clientee;

	}

	public void atualizarTransferencia(Contas remetente, Contas destinatario) {
		try {

			// retirando o valor
			st = conexao.prepareStatement("Update Contas set saldo = ? where numero=?  ");
			st.setDouble(1, remetente.getSaldo());
			st.setString(2, remetente.getNumero());

			st.executeUpdate();

			// add o valor
			st = conexao.prepareStatement("Update Contas set saldo = ? where numero=?  ");
			st.setDouble(1, destinatario.getSaldo());
			st.setString(2, destinatario.getNumero());

			st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}