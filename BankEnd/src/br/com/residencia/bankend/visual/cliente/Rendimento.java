package br.com.residencia.bankend.visual.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.residencia.bankend.contas.ContaPoupanca;
import br.com.residencia.bankend.contas.Contas;

public class Rendimento extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;


	public Rendimento(Contas conta) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 202, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt1 = new JTextField();
		txt1.setBounds(50, 45, 86, 20);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("valor :");
		lblNewLabel.setBounds(10, 48, 36, 14);
		contentPane.add(lblNewLabel);
		
		JButton btn1 = new JButton("calcular");
		btn1.setBounds(50, 146, 89, 23);
		contentPane.add(btn1);
		
		JLabel lbl1 = new JLabel("New label");
		lbl1.setVisible(false);
		lbl1.setBounds(10, 199, 166, 14);
		contentPane.add(lbl1);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(50, 94, 86, 20);
		contentPane.add(txt2);
		
		JLabel lblDias = new JLabel("dias :");
		lblDias.setBounds(10, 97, 31, 14);
		contentPane.add(lblDias);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer dias =	Integer.parseInt(txt1.getText());
				Double	valor =	Double.parseDouble(txt2.getText());
			
			ContaPoupanca continha= (ContaPoupanca) conta;
			 Double resultado = continha.simuRendimento(dias, valor);
			 lbl1.setText(resultado.toString());
			 lbl1.setVisible(true);
			 
			
			
	
				
			}
		});
	}
	
	
}
