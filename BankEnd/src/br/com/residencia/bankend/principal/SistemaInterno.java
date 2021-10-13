package br.com.residencia.bankend.principal;

import java.sql.Connection;

import br.com.residencia.bankend.bd.Conexao;
import br.com.residencia.bankend.visual.Transferencia;

public class SistemaInterno {

	public static void main(String[] args) {
	
		//aguarde o processo
		//polvo lazinhooo
		//c é leigo é
		//machado98 HOHOHO
		
		Connection conexao = new Conexao().conectar();

		Transferencia tela1 = new Transferencia(conexao);

		tela1.setVisible(true);

	}

}
