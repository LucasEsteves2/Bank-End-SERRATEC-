package br.com.residencia.bankend.contas;

import br.com.residencia.bankend.clientes.Cliente;

 public class Contas {

	private String agencia;
	private String numero;
	private String tipo;
	protected Double saldo;
	private Cliente cliente;
	private SeguroVida seguro;

	public Contas(String agencia, String numero, String tipo, Double saldo, Cliente cliente, SeguroVida seguro) {
		this.agencia = agencia;
		this.numero = numero;
		this.tipo = tipo;
		this.saldo = saldo;
		this.cliente = cliente;
		this.seguro = seguro;
	}

	public Double getSaldo() {
		return saldo;
	}

	public boolean saque(double valor) {
		if (this.saldo >= valor) {
			this.saldo = this.saldo - valor;

			return true;
		} else {
			return false;
		}
	}

	public boolean deposito(double valor) {
		if (valor > 0) {
			this.saldo = this.saldo + valor;
			return true;
		} else {
			return false;
		}
	}

	public boolean transferencia(Contas destinatario, double valor) {

		if (this.saldo >= valor) {
			destinatario.deposito(valor);
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
