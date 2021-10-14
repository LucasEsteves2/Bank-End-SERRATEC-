package br.com.residencia.bankend.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

	private String url = "jdbc:postgresql://ec2-3-221-100-217.compute-1.amazonaws.com:5432/d9qrtjkcukvd08";
	private String usuario = "yadwoiqqhkoubd";
	private String senha = "717a7c41f8b5153c1faad21d0357cdd3ede9d99dbb55c5210a0a10d3bc50507c";

	// metodo que faz a conexao

	public Connection conectar() {
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexão Feita com sucesso");
		} catch (Exception e) {
			System.out.println("Falha ao se conectar com o banco de dados");
		}

		return con;
	}

	// metodo pra fechar o statment

	public static void CloseStatement(PreparedStatement st) {

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				System.out.println("st fechado");
				throw new DbException(e.getMessage());

			}
		}

	}

	// metodo para fechar o Result
	public static void CloseResult(ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("rs fechado");

				throw new DbException(e.getMessage());
			}
		}
	}

}
