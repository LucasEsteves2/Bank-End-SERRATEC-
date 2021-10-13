package br.com.residencia.bankend.funcionarios;

public abstract class Funcionario {
	private String nome;
	private String sobreNome;
	private String cargo;
	private String cpf;
	private String email;
	private String senha;
	private Double salario;
	private Integer acesso ;

	public Funcionario(String nome, String sobreNome, String cargo, String cpf, String email, String senha,
			Double salario,Integer acesso) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.cargo = cargo;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.salario = salario;
		this.acesso =acesso;
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
