package br.com.residencia.bankend.visual.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.residencia.bankend.bd.Query;
import br.com.residencia.bankend.contas.ContaCorrente;
import br.com.residencia.bankend.contas.ContaPoupanca;
import br.com.residencia.bankend.contas.Contas;

public class Saque extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String login;
	private String senha;
	private Connection con;
	private JTextField txtValor;
	private Contas contaDestinatario = null;
	private Contas contaRemetente = null;
	ContaCorrente corrente = null;
	private ContaPoupanca poupanca = null;

	private JLabel lblConta;
	private JLabel lblNome;
	private JButton btnVerificar;
	private JLabel lbl1;
	private JLabel lblNomeMaquina;
	private JLabel lblValor;
	private JLabel lblAgencia;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lblTipo;

	public Saque(Connection conexao, Contas contaRemetente) {
		this.con = conexao;
		this.contaRemetente = contaRemetente;

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Saque.class.getResource("/br/com/residencia/bankend/imagens/cadeado-trancado.png")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btn6 = new JButton("6");

		lbl3 = new JLabel("AGENCIA");
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lbl3.setVisible(false);
		lbl3.setForeground(Color.WHITE);
		lbl3.setBounds(732, 403, 59, 14);
		contentPane.add(lbl3);

		lbl2 = new JLabel("CONTA");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lbl2.setVisible(false);

		lblTipo = new JLabel("TIPO");
		lblTipo.setVisible(false);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipo.setBounds(825, 375, 104, 14);
		contentPane.add(lblTipo);
		lbl2.setForeground(Color.WHITE);
		lbl2.setBounds(811, 403, 46, 14);
		contentPane.add(lbl2);

		JButton btnAmarelo = new JButton("");
		btnAmarelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAmarelo.setIcon(new ImageIcon("C:\\Users\\Esteves\\Downloads\\atencao.png"));
		btnAmarelo.setBackground(Color.YELLOW);
		btnAmarelo.setBounds(1170, 534, 48, 22);
		contentPane.add(btnAmarelo);

		lblAgencia = new JLabel("Agencia");
		lblAgencia.setForeground(Color.WHITE);
		lblAgencia.setBounds(737, 424, 59, 14);
		contentPane.add(lblAgencia);

		lblNome = new JLabel("New label");
		lblNome.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 26));
		lblNome.setBounds(796, 327, 197, 54);
		contentPane.add(lblNome);

		JButton btnVerde = new JButton("");
		btnVerde.setIcon(new ImageIcon("C:\\Users\\Esteves\\Downloads\\marca-de-verificacao (2).png"));
		btnVerde.setBackground(new Color(50, 205, 50));
		btnVerde.setBounds(1231, 534, 48, 22);
		contentPane.add(btnVerde);
		btn6.setBackground(Color.LIGHT_GRAY);
		btn6.setBounds(1231, 445, 48, 22);
		contentPane.add(btn6);

		JButton btn0 = new JButton("0");
		btn0.setBackground(Color.LIGHT_GRAY);
		btn0.setBounds(1170, 505, 48, 22);
		contentPane.add(btn0);

		JButton btnVelha = new JButton("#");
		btnVelha.setBackground(Color.LIGHT_GRAY);
		btnVelha.setBounds(1231, 505, 48, 22);
		contentPane.add(btnVelha);

		JButton btnAs = new JButton("*");
		btnAs.setBackground(Color.LIGHT_GRAY);
		btnAs.setBounds(1111, 505, 48, 22);
		contentPane.add(btnAs);

		JButton btnVermelho = new JButton("");
		btnVermelho.setIcon(new ImageIcon("C:\\Users\\Esteves\\Downloads\\cancelar.png"));
		btnVermelho.setBackground(new Color(220, 20, 60));
		btnVermelho.setBounds(1111, 534, 50, 22);
		contentPane.add(btnVermelho);

		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.setBounds(1111, 416, 48, 22);
		contentPane.add(btn1);
//aaa
		JButton btn8 = new JButton("8");
		btn8.setBackground(Color.LIGHT_GRAY);
		btn8.setBounds(1170, 476, 48, 22);
		contentPane.add(btn8);

		JButton btn9 = new JButton("9");
		btn9.setBackground(Color.LIGHT_GRAY);
		btn9.setBounds(1231, 476, 48, 22);
		contentPane.add(btn9);

		JButton btn7 = new JButton("7");
		btn7.setBackground(Color.LIGHT_GRAY);
		btn7.setBounds(1111, 475, 48, 22);
		contentPane.add(btn7);

		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn2.setBackground(Color.LIGHT_GRAY);
		btn2.setBounds(1170, 416, 48, 22);
		contentPane.add(btn2);

		JButton btn3 = new JButton("3");
		btn3.setBackground(Color.LIGHT_GRAY);
		btn3.setBounds(1231, 416, 48, 22);
		contentPane.add(btn3);

		JButton btn4 = new JButton("4");

		btn4.setBackground(Color.LIGHT_GRAY);
		btn4.setBounds(1110, 445, 48, 22);
		contentPane.add(btn4);

		JButton btn5 = new JButton("5");
		btn5.setBackground(Color.LIGHT_GRAY);
		btn5.setBounds(1170, 445, 48, 22);
		contentPane.add(btn5);

		lblConta = new JLabel("Conta:");
		lblConta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConta.setForeground(Color.WHITE);
		lblConta.setBackground(Color.WHITE);
		lblConta.setBounds(812, 424, 90, 14);
		contentPane.add(lblConta);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Esteves\\Downloads\\A23.png"));
		lblNewLabel_1.setBounds(701, 412, 214, 43);
		contentPane.add(lblNewLabel_1);

		btnVerificar = new JButton("VERIFICAR");

		btnVerificar.setBounds(818, 381, 97, 23);
		contentPane.add(btnVerificar);

		lblValor = new JLabel("INFORME UM VALOR");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblValor.setBounds(1140, 284, 113, 15);
		contentPane.add(lblValor);

		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(1145, 309, 97, 20);
		contentPane.add(txtValor);

		lblNomeMaquina = new JLabel("Cliente: Lucas Esteves");
		lblNomeMaquina.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeMaquina.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNomeMaquina.setForeground(Color.DARK_GRAY);
		lblNomeMaquina.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomeMaquina.setBounds(1117, 165, 151, 17);
		contentPane.add(lblNomeMaquina);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\oriignal2.png"));
		lblNewLabel_3.setBounds(921, -538, 1026, 1913);
		contentPane.add(lblNewLabel_3);

		lbl1 = new JLabel("Conta:");
		lbl1.setForeground(Color.WHITE);
		lbl1.setBackground(Color.WHITE);
		lbl1.setBounds(797, 331, 158, 14);
		contentPane.add(lbl1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\card222323.png"));
		lblNewLabel.setBounds(512, 143, 638, 365);
		contentPane.add(lblNewLabel);

		JLabel ImgBackground = new JLabel("");
		ImgBackground.setBounds(0, 0, 1375, 705);
		ImgBackground.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\2133232232323.jpg"));
		contentPane.add(ImgBackground);

		Query bd = new Query(con);

		lblNome.setVisible(false);

		// setando visibilidade dos components

		lblConta.setVisible(false);
		lblNomeMaquina.setVisible(false);
		lblAgencia.setVisible(false);

		
		
		//pegando dados dos usuarios

		String nome1 = contaRemetente.getCliente().getNome();
		String sobrenome = contaRemetente.getCliente().getSobreNome();

		// setando textos
		lblConta.setText(contaRemetente.getNumero());
		lblNome.setText(nome1 + " " + sobrenome);
		lblAgencia.setText(contaRemetente.getAgencia());
		lblTipo.setText("Conta: " + contaRemetente.getTipo());

		// setando visibilidade dos componentes
		lblConta.setVisible(true);
		btnVerificar.setVisible(false);
		lbl1.setVisible(false);
		lblNome.setVisible(true);
		lblNomeMaquina.setVisible(false);
		lblValor.setVisible(true);
		txtValor.setVisible(true);
		lbl2.setVisible(true);
		lbl3.setVisible(true);
		lblAgencia.setVisible(true);
		lblTipo.setVisible(true);
		
		
		btnVerde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// pegando e convertendo valor inforamdo
				String valor = txtValor.getText();
				Double saldo = Double.parseDouble(valor);

				System.out.println(valor);

				// verificando qual conta é
				if (contaRemetente.getTipo().equals("corrente")) {

					// fazend o cast
					corrente = (ContaCorrente) contaRemetente;

					corrente.saque(saldo, contaRemetente);

					// gambiarra refazendo o cast
					Contas contaRemetnetee = null;

					contaRemetnetee = corrente;

					bd.deposito(contaRemetnetee,saldo);

				}

				if (contaRemetente.getTipo().equals("poupanca")) {

					poupanca = (ContaPoupanca) contaRemetente;

					poupanca.saque(saldo,contaRemetente);

					// gambiarra refazendo o cast
					Contas contaRemetnetee = null;

					contaRemetnetee = poupanca;

					bd.deposito(contaRemetnetee,saldo);

					System.out.println("SOU POUPANCA");
				}

			}
		});

	}

}
