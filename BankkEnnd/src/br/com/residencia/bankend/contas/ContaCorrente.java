package br.com.residencia.bankend.contas;

import java.util.ArrayList;

import br.com.residencia.bankend.clientes.Cliente;

public class ContaCorrente extends Contas {
	private ArrayList<Tributos> tributos = new ArrayList<>();

	public ContaCorrente(String agencia, String numero, String tipo, Double saldo, Cliente cliente, SeguroVida seguro) {
		super(agencia, numero, tipo, saldo, cliente, seguro);

	}

	@Override
	public boolean saque(double valor) {

		if (this.saldo >= (valor + 0.10)) {
			this.saldo = this.saldo - valor - 0.10;

			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deposito(double valor) {
		if ((valor > 0)  && (this.saldo>=0.10)) {
			this.saldo = this.saldo + valor;
			return true;
		} else {
			return false;
		}

	}
	

}