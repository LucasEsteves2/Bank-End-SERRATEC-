package br.com.residencia.bankend.contas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Comprovante {
	public static void deposito (Contas conta,Double valor,String tipoConta) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String data = dtf.format(LocalDateTime.now());
		File arquivo = new File( "C:\\temp\\"+data+"  deposito.txt" );
		boolean existe = arquivo.exists();
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
		bw.write( "valor do depósito : "+"R$ "+valor );
		bw.newLine();
		bw.close();
		fw.close();
		}
		
		else {
			bw.write( "--------------- DEPÓSITO --------------- ");
			bw.newLine();
			bw.write( "Operação realizada : "+ "DEPÓSITO" );
			bw.newLine();
			bw.write( "taxa da operação : "+ "R$" + "0.10");
			bw.newLine();
			bw.write( "favorecido  "+conta.getCliente().getNome() );
			bw.newLine();
			bw.write( "conta favorecida :  "+conta.getNumero() );
			bw.newLine();
			bw.write( "valor do depósito : "+"R$ "+valor );
			bw.newLine();
			bw.close();
			fw.close();
					
		}
		
	}
	
	public static void saque (Contas conta,Double valor) throws IOException {
	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String data = dtf.format(LocalDateTime.now());
		File arquivo = new File( "C:\\temp\\"+data+"  saque.txt" );
		boolean existe = arquivo.exists();
		arquivo.createNewFile();
		
		FileWriter fw = new FileWriter( arquivo );
		BufferedWriter bw = new BufferedWriter( fw );
		
		if(conta.tipo.equalsIgnoreCase("corrente")) {
		bw.write( "--------------- Saque --------------- ");
		bw.newLine();
		bw.write( "Operação realizada : "+ "Saque" );
		bw.newLine();
		bw.write( "valor do saque : "+"R$ "+valor );
		bw.newLine();
		bw.write( "Saldo  atual:  "+conta.getSaldo() );
		bw.close();
		fw.close();
		
		}
		bw.write( "--------------- Saque --------------- ");
		bw.newLine();
		bw.write( "Operação realizada : "+ "Saque" );
		bw.newLine();
		bw.write( "taxa da operação : "+"R$ "+"0.10" );
		bw.newLine();
		bw.write( "valor do saque : "+"R$ "+valor );
		bw.newLine();
		bw.write( "Saldo  atual:  "+"R$ "+conta.getSaldo() );
		bw.close();
		fw.close();
		
	}
	
	
	public static void Transferencia (Contas conta,Double valor) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String data = dtf.format(LocalDateTime.now());
		File arquivo = new File( "C:\\temp\\"+data+"  Transferência.txt" );
		boolean existe = arquivo.exists();
		arquivo.createNewFile();
		
		FileWriter fw = new FileWriter( arquivo );
		BufferedWriter bw = new BufferedWriter( fw );
		if(conta.tipo.equalsIgnoreCase("corrente")) {
		bw.write( "--------------- Transferência --------------- ");
		bw.newLine();
		bw.write( "Operação realizada : "+ "Transferência" );
		bw.newLine();
		bw.write( "valor da transferência: "+"R$ "+valor);
		bw.newLine();
		bw.write( "favorecido  "+conta.getCliente().getNome() );
		bw.newLine();
		bw.write( "conta favorecida :  "+conta.getNumero() );
		bw.newLine();
		fw.close();
		}else {
			bw.write( "--------------- Transferência --------------- ");
			bw.newLine();
			bw.write( "Operação realizada : "+ "Transferência" );
			bw.newLine();
			bw.write( "taxa da operação : "+"R$ "+"0.20" );
			bw.newLine();
			bw.write( "valor da transferência: "+"R$ "+valor);
			bw.newLine();
			bw.write( "favorecido  "+conta.getCliente().getNome() );
			bw.newLine();
			bw.write( "conta favorecida :  "+conta.getNumero() );
			bw.close();
			fw.close();
			}
		}
		
	}

