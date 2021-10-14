package br.com.residencia.bankend.principal;

import java.sql.Connection;

import br.com.residencia.bankend.bd.Conexao;
import br.com.residencia.bankend.visual.TelaLogin;

public class SistemaInterno {

	public static void main(String[] args) {

		Connection conexao = new Conexao().conectar();

		

	}

}
