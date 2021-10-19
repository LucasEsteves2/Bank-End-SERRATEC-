package br.com.residencia.bankend.contas;

public class SeguroVida {
	
	private Double valor;
	private Double taxa;
	
	
	public SeguroVida(Double valor)
	{
		this.valor=valor;
	}
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Double getTaxa() {
		return taxa;
	}
	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	
	public void calculo(Double value)
	{
		taxa=value*0.20;
	}
}
