package br.com.residencia.bankend.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.residencia.bankend.clientes.Cliente;

import javax.swing.JLabel;

public class Saldo extends JFrame {

	private JPanel contentPane;

	public Saldo(Cliente cliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Seu saldo \u00E9 ");
		lblNewLabel_1.setBounds(82, 43, 102, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblSaldo = new JLabel("");
		lblSaldo.setVisible(false);
		lblSaldo.setBounds(156, 42, 60, 14);
		contentPane.add(lblSaldo);

		JLabel lblNome = new JLabel("NOME:");
		lblNome.setBounds(177, 7, 46, 14);
		contentPane.add(lblNome);

		lblSaldo.setVisible(true);

		lblNome.setText(cliente.getNome());

	}
}
