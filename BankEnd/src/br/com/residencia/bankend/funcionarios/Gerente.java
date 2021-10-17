package br.com.residencia.bankend.funcionarios;

import java.util.ArrayList;

import br.com.residencia.bankend.contas.Contas;

public class Gerente extends Funcionario {
	private String idAgencia;
	private Integer numeroContas;
	private ArrayList <Contas> listaContasAgencia = new ArrayList<>();
	

	public Gerente(String nome, String sobreNome, String cargo, String cpf, String email, String senha, Double salario,
			Integer acesso, String idAgencia) {
		super(nome, sobreNome, cargo, cpf, email, senha, salario, acesso);
		this.idAgencia = idAgencia;
	}


	public String getIdAgencia() {
		return idAgencia;
	}


	
	
	
}
