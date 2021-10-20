package br.com.residencia.bankend.contas;

import java.util.ArrayList;

import br.com.residencia.bankend.clientes.Cliente;

public class ContaCorrente extends Contas {
	private ArrayList<Tributos> tributos = new ArrayList<>();

	public ContaCorrente(String agencia, String numero, String tipo, Double saldo, Cliente cliente, SeguroVida seguro,Integer id) {
		super(agencia, numero, tipo, saldo, cliente, seguro, id);

	}

	public ArrayList<Tributos> getTributos() {
		return tributos;
	}

	public void setTributos(ArrayList<Tributos> tributos) {
		this.tributos = tributos;
	}

	@Override
	public boolean saque(double valor,Contas remetente) {
	
		
		if (remetente.saldo >= (valor + 0.10)&& valor>0) {
			remetente.saldo = (remetente.saldo - 0.10)- valor ;

			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deposito(Contas destinatario,double valor) {
		if ((valor > 0)  && (this.saldo>=0.10)) {
			destinatario.saldo = destinatario.saldo + valor;
			this.saldo = this.saldo - 0.10;
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean transferencia(Contas destinatario, double valor) {

		if (this.saldo >= (valor+0.20) &&valor>0) {
			destinatario.saldo = destinatario.saldo + valor;
			this.saldo = (this.saldo-0.20) - valor;
			return true;

		} else {
			return false;
		}
	}
	

}
