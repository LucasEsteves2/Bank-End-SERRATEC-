package br.com.residencia.bankend.contas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Comprovante {
	public static void deposito (Contas conta,Double valor,String tipoConta) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm.ss");
		String data = dtf.format(LocalDateTime.now());
		
		File arquivo = new File( "C:\\temp\\"+data+"  deposito.txt" );
		arquivo.createNewFile();
		
		FileWriter fw = new FileWriter( arquivo );
		BufferedWriter bw = new BufferedWriter( fw );
		
		
		if(tipoConta.equalsIgnoreCase("corrente")) {
		bw.write( "--------------- DEPÓSITO --------------- ");
		bw.newLine();
		bw.write( "Operação realizada : "+ "DEPÓSITO" );
		bw.newLine();
		bw.write( "favorecido  "+conta.getCliente().getNome() );
		bw.newLine();
		bw.write( "conta favorecida :  "+conta.getNumero() );
		bw.newLine();
		bw.write( "valor do depósito : "+"R$ "+String.format("%.2f",valor) );
		bw.newLine();
		}
		
		else {
			bw.write( "--------------- DEPÓSITO --------------- ");
			bw.newLine();
			bw.write( "Operação realizada : "+ "DEPÓSITO" );
			bw.newLine();
			bw.write( "favorecido  "+conta.getCliente().getNome() );
			bw.newLine();
			bw.write( "conta favorecida :  "+conta.getNumero() );
			bw.newLine();
			bw.write( "valor do depósito : "+"R$ "+String.format("%.2f",valor) );
			bw.newLine();
		
					
		}
		bw.close();
		fw.close();
	}
	
	public static void saque (Contas conta,Double valor) throws IOException {
	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm.ss");
		String data = dtf.format(LocalDateTime.now());
		File arquivo = new File( "C:\\temp\\"+data+"  saque.txt" );
		arquivo.createNewFile();
		
		FileWriter fw = new FileWriter( arquivo );
		BufferedWriter bw = new BufferedWriter( fw );
		
		if(conta.tipo.equalsIgnoreCase("corrente")) {
		bw.write( "--------------- Saque --------------- ");
		bw.newLine();
		bw.write( "Operação realizada : "+ "Saque" );
		bw.newLine();
		bw.write( "valor do saque : "+"R$ "+String.format("%.2f",valor) );
		bw.newLine();
		bw.write( "Saldo  atual:  "+String.format("%.2f",conta.getSaldo() ));
		
		
		}else {
		bw.write( "--------------- Saque --------------- ");
		bw.newLine();
		bw.write( "Operação realizada : "+ "Saque" );
		bw.newLine();
		bw.write( "valor do saque : "+"R$ "+String.format("%.2f",valor) );
		bw.newLine();
		bw.write( "Saldo  atual:  "+"R$ "+String.format("%.2f",conta.getSaldo() ));
		
		}
		bw.close();
		fw.close();
	}
	
	
	public static void Transferencia (Contas conta,Double valor) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm.ss");
		String data = dtf.format(LocalDateTime.now());
		File arquivo = new File( "C:\\temp\\"+data+"  Transferência.txt" );
		arquivo.createNewFile();
		
		FileWriter fw = new FileWriter( arquivo );
		BufferedWriter bw = new BufferedWriter( fw );
		if(conta.tipo.equalsIgnoreCase("corrente")) {
		bw.write( "--------------- Transferência --------------- ");
		bw.newLine();
		bw.write( "Operação realizada : "+ "Transferência" );
		bw.newLine();
		bw.write( "valor da transferência: "+"R$ "+String.format("%.2f",valor));
		bw.newLine();
		bw.write( "favorecido  "+conta.getCliente().getNome() );
		bw.newLine();
		bw.write( "conta favorecida :  "+conta.getNumero() );
		
		}else {
			bw.write( "--------------- Transferência --------------- ");
			bw.newLine();
			bw.write( "Operação realizada : "+ "Transferência" );
			bw.newLine();
			bw.write( "valor da transferência: "+"R$ "+String.format("%.2f",valor));
			bw.newLine();
			bw.write( "favorecido  "+conta.getCliente().getNome() );
			bw.newLine();
			bw.write( "conta favorecida :  "+conta.getNumero() );
			
			}
		bw.close();
		fw.close();
		}
	
	public static void tributos (ContaCorrente conta) throws IOException {
		double saqueTotal= conta.getTributos().get(0).getValor()*0.10;
		double depositoTotal= conta.getTributos().get(1).getValor()*0.10;
		double trasnfenciaTotal=conta.getTributos().get(2).getValor()*0.20;;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm.ss");
		String data = dtf.format(LocalDateTime.now());
		File arquivo = new File( "C:\\temp\\"+data+"  tributos.txt" );
		arquivo.createNewFile();
		FileWriter fw = new FileWriter( arquivo );
		BufferedWriter bw = new BufferedWriter( fw );
		
		if(conta.tipo.equalsIgnoreCase("corrente")) {
		bw.write( "------------------------------------------------------------ tributos ------------------------------------------------------------");
		bw.newLine();
		bw.write( "--------------- Taxas ---------------");
		bw.newLine();
		bw.write( "valor cobrado por depósito : R$:0,10");
		bw.newLine();
		bw.write( "valor cobrado por saque : R$:0,10");
		bw.newLine();
		bw.write( "valor cobrado por transferencia: R$:0,20");
		bw.newLine();
		bw.newLine();
		bw.write( "--------------- Gastos ---------------");
		
		
		for(int i = 0 ;i<=1;i++) {
		bw.newLine();
		bw.write( "numero de "+conta.getTributos().get(i).getNome()+" feitos : " +conta.getTributos().get(i).getValor());
		bw.newLine();
		bw.write( "valor gasto em  "+ conta.getTributos().get(i).getNome() +" : "+" R$ "+String.format("%.2f",conta.getTributos().get(i).getValor()*0.10)  );
		bw.newLine();
		}
		bw.newLine();
		bw.write( "numero de "+conta.getTributos().get(2).getNome()+" feitos : " +conta.getTributos().get(2).getValor());
		bw.newLine();
		bw.write( "valor gasto em  "+ conta.getTributos().get(2).getNome() +" : "+" R$ "+String.format("%.2f",conta.getTributos().get(2).getValor()*0.20)  );
		bw.newLine();
		bw.newLine();
		if(conta.seguro != null) {
			bw.write( "--------------- Seguro ---------------");
			bw.newLine();
			bw.newLine();
			bw.write( "gasto com seguro :  R$"+String.format("%.2f",conta.getSeguro().getTaxa()));
			bw.newLine();
			bw.newLine();
			bw.write( "--------------- Total ---------------");
			bw.newLine();
			bw.write( "gastos totais :  R$"+String.format("%.2f",saqueTotal+depositoTotal+trasnfenciaTotal+conta.getSeguro().getTaxa()));
			
			bw.close();
			fw.close();
		}
		else {
		bw.write( "--------------- Total ---------------");
		bw.newLine();
		bw.write( "gastos totais :  R$"+String.format("%.2f",saqueTotal+depositoTotal+trasnfenciaTotal));
		
		bw.close();
		fw.close();
		}
	}
		
	}
	}

