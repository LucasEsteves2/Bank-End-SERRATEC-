package br.com.residencia.bankend.contas;

import br.com.residencia.bankend.clientes.Cliente;

public class ContaPoupanca extends Contas {
private static final double rendimento =0.017;

	public ContaPoupanca(String agencia, String numero, String tipo, Double saldo, Cliente cliente, SeguroVida seguro, Integer id) {
		super(agencia, numero, tipo, saldo, cliente, seguro, id);

	}
	

	public double simuRendimento(int dias,double valor) {
		return valor*rendimento*dias;
		
	}
	

	
	
	
	

}
