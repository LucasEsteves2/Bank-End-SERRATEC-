package br.com.residencia.bankend.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.residencia.bankend.clientes.Cliente;
import br.com.residencia.bankend.contas.Contas;

import javax.swing.JLabel;

public class Saldo extends JFrame {

	private JPanel contentPane;

	public Saldo(Contas continha) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSaldo = new JLabel("Seu saldo \u00E9 ");
		lblSaldo.setBounds(82, 43, 235, 14);
		contentPane.add(lblSaldo);

		JLabel lblNome = new JLabel("NOME:");
		lblNome.setBounds(160, 11, 147, 21);
		contentPane.add(lblNome);

		
		JLabel lblTipo = new JLabel("New label");
		lblTipo.setBounds(82, 92, 289, 14);
		contentPane.add(lblTipo);
		
		JLabel lblAgencia = new JLabel("New label");
		lblAgencia.setBounds(82, 141, 272, 14);
		contentPane.add(lblAgencia);
		
		JLabel lblNumero = new JLabel("New label");
		lblNumero.setBounds(82, 192, 209, 14);
		contentPane.add(lblNumero);
		
		
		
		
		lblNome.setText("NOME: "+ continha.getCliente().getNome());
		lblAgencia.setText("AGENCIA: "+continha.getAgencia());
		lblSaldo.setText("SALDO: "+continha.getSaldo().toString());
		lblTipo.setText("TIPO: "+continha.getTipo());
		lblNumero.setText("NUMERO: "+ continha.getNumero());
		
	}
}
