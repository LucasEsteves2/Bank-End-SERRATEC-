package br.com.residencia.bankend.visual.cliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.ScrollPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class TelaSeguroVidaa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtValor;

	public TelaSeguroVidaa(Connection con) {

		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSeguroVidaa.class.getResource("/passport (1).png")));
		setTitle("Seguro de vida");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-3, -18, 499, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTelaInicial = new JLabel("");
		lblTelaInicial.setIcon(new ImageIcon(TelaSeguroVidaa.class.getResource("/previous (2).png")));
		lblTelaInicial.setBounds(15, 365, 37, 33);
		contentPane.add(lblTelaInicial);

		JLabel lblSeguro1 = new JLabel("Informe o valor do seguro desejado");
		lblSeguro1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSeguro1.setBounds(31, 13, 240, 20);
		contentPane.add(lblSeguro1);

		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(273, 11, 86, 24);
		contentPane.add(txtValor);

		JButton btnproximo = new JButton("contratar");
		btnproximo.setBounds(368, 11, 85, 23);
		contentPane.add(btnproximo);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(-14, 40, 519, 8);
		contentPane.add(scrollPane);

		JPanel pnlcorprincip = new JPanel();
		pnlcorprincip.setBackground(new Color(0, 255, 127));
		pnlcorprincip.setBounds(0, 0, 505, 40);
		contentPane.add(pnlcorprincip);

		JPanel pnlCor = new JPanel();
		pnlCor.setBackground(new Color(0, 255, 255));
		pnlCor.setBounds(-1, -1, 506, 44);
		contentPane.add(pnlCor);
		pnlCor.setLayout(null);

		JLabel lblVoltar = new JLabel("VOLTAR");
		lblVoltar.setBounds(15, 359, 85, 44);
		contentPane.add(lblVoltar);
		lblVoltar.setFont(new Font("Arial", Font.BOLD, 11));
		lblVoltar.setIcon(new ImageIcon(TelaSeguroVidaa.class.getResource("/previous (2).png")));
		JLabel background = new JLabel("\r\n");
		background.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\BANKEND\\mauqina\\seguri.jpg"));
		background.setBounds(-3, 44, 496, 370);
		contentPane.add(background);
		pnlCor.setVisible(false);
		lblVoltar.setVisible(false);

	


}

}






