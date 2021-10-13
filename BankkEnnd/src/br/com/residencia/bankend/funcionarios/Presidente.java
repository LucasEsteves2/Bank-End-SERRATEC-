package br.com.residencia.bankend.funcionarios;

import java.util.ArrayList;

import br.com.residencia.bankend.contas.Contas;

public class Presidente  extends Funcionario{
	
	private Integer valorTotal;
	private ArrayList <Contas> listaContas = new ArrayList<>();

	public Presidente(String nome, String sobreNome, String cargo, String cpf, String email, String senha,
			Double salario) {
		super(nome, sobreNome, cargo, cpf, email, senha, salario);
		
	}

}
