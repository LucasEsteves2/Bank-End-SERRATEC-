package br.com.residencia.bankend.clientes;

public class Cliente {
	private String nome;
	private String sobreNome;
	private String email;
	private String cpf;
	private String senha;
	private static Integer acesso =0;
	
	public Cliente(String nome, String sobreNome, String email, String cpf, String senha) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}
	
	
	
	
	
	
	
	
}
