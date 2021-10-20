package br.com.residencia.bankend.funcionarios;

import java.util.ArrayList;

import br.com.residencia.bankend.contas.Contas;

public class Diretor extends Funcionario{
	@SuppressWarnings("unused")
	private ArrayList <Contas> listaContasDiretor = new ArrayList<>();

	public Diretor(String nome, String sobreNome, String cargo, String cpf, String email, String senha, Double salario,
			Integer acesso, ArrayList<Contas> listaContasDiretor) {
		super(nome, sobreNome, cargo, cpf, email, senha, salario, acesso);
		this.listaContasDiretor = listaContasDiretor;
	}
	
	



}
