package br.com.residencia.bankend.bd;

public class DbException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	
	public DbException(String mensagem)
	{
		super(mensagem);
		
	}
	
} 
