package br.com.residencia.bankend.funcionarios;

public abstract class Funcionario {
	private String nome;
	private String sobreNome;
	private String cargo;
	private String cpf;
	private String email;
	private String senha;
	private Double salario;

	public Funcionario(String nome, String sobreNome, String cargo, String cpf, String email, String senha,
			Double salario) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.cargo = cargo;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public String getCargo() {
		return cargo;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public Double getSalario() {
		return salario;
	}

}
