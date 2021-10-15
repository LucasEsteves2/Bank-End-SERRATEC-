package br.com.residencia.bankend.clientes;

public class Cliente {
	private String nome;
	private String sobreNome;
	private String email;
	private String cpf;
	private String senha;
	private int id;
	private static Integer acesso =0;
	




	public void setId(int id) {
		this.id = id;
	}



	public  Cliente(String nome, String sobreNome, String email, String cpf, String senha, int id) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.id=id;
	}

	
	
	public int getId() {
		return id;
	}



	public String getNome() {
		return nome;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public static Integer getAcesso() {
		return acesso;
	}

	
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", sobreNome=" + sobreNome + ", email=" + email + ", cpf=" + cpf + ", senha="
				+ senha + ", id=" + id + "]";
	}
	
	
}
