package br.com.residencia.main;

import java.sql.Connection;

import br.com.residencia.banco.Conexao;
import br.com.residencia.banco.Query;
import br.com.residencia.telas.Tela1;

public class Principal {

	public static void main(String[] args) {

		Connection conexao;

		Conexao con = new Conexao();

		conexao = con.conectar();

		Query sql = new Query(conexao);

		sql.mostra();

	}
}
