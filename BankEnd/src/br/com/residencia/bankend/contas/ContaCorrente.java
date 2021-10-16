package br.com.residencia.bankend.contas;

import java.util.ArrayList;

import br.com.residencia.bankend.clientes.Cliente;

public class ContaCorrente extends Contas {
	private ArrayList<Tributos> tributos = new ArrayList<>();

	public ContaCorrente(String agencia, String numero, String tipo, Double saldo, Cliente cliente, SeguroVida seguro,Integer id) {
		super(agencia, numero, tipo, saldo, cliente, seguro, id);

	}

	@Override
	public boolean saque(double valor,Contas destinatario) {

		if (destinatario.saldo >= (valor + 0.10)) {
			destinatario.saldo = destinatario.saldo - valor - 0.10;

			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deposito(Contas destinatario,double valor) {
		if ((valor > 0)  && (this.saldo>=0.10)) {
			destinatario.saldo = destinatario.saldo + valor;
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean transferencia(Contas destinatario, double valor) {


		if (this.saldo >= (valor+0.20)) {
			destinatario.saldo = destinatario.saldo + valor;
			this.saldo = this.saldo - valor-0.20;
			return true;

		} else {
			return false;
		}
	}
	

}
