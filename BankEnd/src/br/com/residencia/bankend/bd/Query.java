package br.com.residencia.bankend.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Query {

	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private Connection con;

	public Query(Connection conexao) {
		this.con = conexao;

	}

	public void mostra() {
		try {
			System.out.println("ss");

			stmt = con.prepareStatement("select *from admin ");

			stmt.execute();

			rs = stmt.getResultSet();

			while (rs.next()) {

				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));

			}

		} catch (Exception e) {
			System.out.println("deu merda");
		}

	}

}
