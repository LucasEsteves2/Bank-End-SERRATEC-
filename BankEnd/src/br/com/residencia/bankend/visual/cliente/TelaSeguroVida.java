package br.com.residencia.bankend.visual.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.residencia.bankend.contas.Contas;
import br.com.residencia.bankend.contas.SeguroVida;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaSeguroVida extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;

	public TelaSeguroVida(Contas conta) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtValor = new JTextField();
		txtValor.setBounds(67, 65, 117, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("valor");
		lblNewLabel.setBounds(108, 40, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnVerifica = new JButton("New button");
		
		btnVerifica.setBounds(77, 96, 89, 23);
		contentPane.add(btnVerifica);
		
		//add verifica
		
		
		
		
		
		
		btnVerifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Double valor = Double.parseDouble(txtValor.getText());
				SeguroVida seguro = new SeguroVida(valor);
				
				seguro.calculo(valor);
				
				conta.setSeguro(seguro);
				
				
			}
		});
		
	}

}
