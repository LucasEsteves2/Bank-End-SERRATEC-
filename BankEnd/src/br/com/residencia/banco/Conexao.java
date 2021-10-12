package br.com.residencia.banco;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private String url = "jdbc:postgresql://ec2-3-221-100-217.compute-1.amazonaws.com:5432/d9qrtjkcukvd08";
	private String usuario = "yadwoiqqhkoubd";
	private String senha = "717a7c41f8b5153c1faad21d0357cdd3ede9d99dbb55c5210a0a10d3bc50507c";

	public Connection conectar() {
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectado");
		} catch (Exception e) {
			System.out.println("Falha ao se conectar com o banco de dados");
		}

		return con;
	}

}
