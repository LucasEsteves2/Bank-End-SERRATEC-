package br.com.residencia.bankend.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Query {
	private Connection conexao = null;
	private PreparedStatement st = null;
	private ResultSet rs = null;

	public Query(Connection conexao) {

		this.conexao = conexao;
	}

	public boolean verifica(String login, String senha) {

		try {
			st = conexao.prepareStatement("select login,senha from admin where login = ? and senha =? ");
			st.setString(1, login);
			st.setString(2, senha);
			st.execute();

			rs = st.getResultSet();

			if (rs.next()) {

				return true;
			} else {

				return false;
			}

		} catch (Exception e) {

		}
		return false;

	}

}