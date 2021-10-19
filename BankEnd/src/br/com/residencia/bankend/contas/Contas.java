package br.com.residencia.bankend.contas;

import br.com.residencia.bankend.clientes.Cliente;

 public abstract class Contas {

	protected String agencia;
	protected String numero;
	protected String tipo;
	protected Double saldo;
	protected Cliente cliente;
	protected SeguroVida seguro;
	protected Integer id;

	public Contas(String agencia, String numero, String tipo, Double saldo, Cliente cliente, SeguroVida seguro,Integer id) {
		this.agencia = agencia;
		this.numero = numero;
		this.tipo = tipo;
		this.saldo = saldo;
		this.cliente = cliente;
		this.seguro = seguro;
		this.id=id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Integer getId() {
		return id;
	}

	public boolean saque(double valor,Contas remetente) {
		if (remetente.saldo >= valor) {
			remetente.saldo = remetente.saldo - valor;

			return true;
		} else {
			return false;
		}
	}

	public boolean deposito(Contas destinatario,double valor) {
		if (valor > 0) {
			destinatario.saldo = destinatario.saldo + valor;
			return true;
		} else {
			return false;
		}
	}

	public boolean transferencia(Contas destinatario, double valor) {

		if (this.saldo >= valor) {
			destinatario.saldo = destinatario.saldo + valor;
			this.saldo = this.saldo - valor;
			
			
			
			return true;

		} else {
			return false;
		}
	}

	public SeguroVida getSeguro() {
		return seguro;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getNumero() {
		return numero;
	}

	public String getTipo() {
		return tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	
	
	
}
