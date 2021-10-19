package br.com.residencia.bankend.visual.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
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
import javax.swing.border.LineBorder;

import br.com.residencia.bankend.bd.Query;
import br.com.residencia.bankend.contas.Comprovante;
import br.com.residencia.bankend.contas.ContaCorrente;
import br.com.residencia.bankend.contas.ContaPoupanca;
import br.com.residencia.bankend.contas.Contas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Transferencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String login;
	private String senha;
	private Connection con;
	private JTextField txtCartao;
	private JTextField txtValor;
	private Contas contaDestinatario = null;
	private Contas contaRemetente = null;
	ContaCorrente corrente = null;
	private ContaPoupanca poupanca = null;

	private JLabel lblConta;
	private JLabel lblNome;
	private JButton btnVerificar;
	private JLabel lbl1;
	private JLabel lblNomeRecibo;
	private JLabel lblValor;
	private JLabel lblAgencia;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lblTipo;
	private JLabel imgMaquina;
	private JLabel lblCupomNome;
	private JLabel lblCupomContaa;
	private JLabel lblCupomFavorecido;
	private JLabel lblCupomTipoConta;
	private JLabel lblCupomAgencia;
	private JLabel lblSair;
	private JLabel lblCaixaSaldo;
	private JLabel lblCaixaEletronico;
	private JLabel ImgBackground;
	private Double transferencia;

	public Transferencia(Connection conexao, Contas contaRemetenteV) {
		this.con = conexao;
		this.contaRemetente = contaRemetenteV;

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Transferencia.class.getResource("/br/com/residencia/bankend/imagens/cadeado-trancado.png")));
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

		lblCupomAgencia = new JLabel("");
		lblCupomAgencia.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCupomAgencia.setForeground(new Color(128, 128, 128));
		lblCupomAgencia.setBounds(1134, 211, 129, 14);
		contentPane.add(lblCupomAgencia);

		lblCupomTipoConta = new JLabel("");
		lblCupomTipoConta.setHorizontalAlignment(SwingConstants.LEFT);
		lblCupomTipoConta.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCupomTipoConta.setForeground(SystemColor.controlShadow);
		lblCupomTipoConta.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCupomTipoConta.setBounds(1127, 126, 136, 17);

		contentPane.add(lblCupomTipoConta);

		lblCupomNome = new JLabel("");
		lblCupomNome.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCupomNome.setForeground(new Color(128, 128, 128));
		lblCupomNome.setBounds(1134, 167, 129, 14);
		contentPane.add(lblCupomNome);

		lblCupomContaa = new JLabel("");
		lblCupomContaa.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCupomContaa.setForeground(new Color(128, 128, 128));
		lblCupomContaa.setBounds(1134, 189, 129, 14);
		contentPane.add(lblCupomContaa);

		lblCupomFavorecido = new JLabel("");
		lblCupomFavorecido.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCupomFavorecido.setForeground(new Color(128, 128, 128));
		lblCupomFavorecido.setBounds(1163, 147, 100, 14);
		contentPane.add(lblCupomFavorecido);

		lbl3.setForeground(Color.WHITE);
		lbl3.setBounds(732, 403, 59, 14);
		contentPane.add(lbl3);

		lbl2 = new JLabel("CONTA");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lbl2.setVisible(false);

		lblTipo = new JLabel("TIPO");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setVisible(false);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipo.setBounds(862, 274, 159, 14);
		contentPane.add(lblTipo);
		lbl2.setForeground(Color.WHITE);
		lbl2.setBounds(821, 403, 46, 14);
		contentPane.add(lbl2);

		JButton btnAmarelo = new JButton("");
		btnAmarelo.setIcon(new ImageIcon("C:\\Users\\Esteves\\Downloads\\atencao.png"));
		btnAmarelo.setBackground(Color.YELLOW);
		btnAmarelo.setBounds(1170, 648, 48, 22);
		contentPane.add(btnAmarelo);

		lblAgencia = new JLabel("Agencia");
		lblAgencia.setForeground(Color.WHITE);
		lblAgencia.setBounds(737, 424, 59, 14);
		contentPane.add(lblAgencia);

		lblNome = new JLabel("New label");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 24));
		lblNome.setBounds(793, 327, 199, 54);
		contentPane.add(lblNome);

		JButton btnVerde = new JButton("");
		btnVerde.setIcon(new ImageIcon("C:\\Users\\Esteves\\Downloads\\marca-de-verificacao (2).png"));
		btnVerde.setBackground(new Color(50, 205, 50));
		btnVerde.setBounds(1231, 648, 48, 22);
		contentPane.add(btnVerde);
		btn6.setBackground(Color.LIGHT_GRAY);
		btn6.setBounds(1231, 559, 48, 22);
		contentPane.add(btn6);

		JButton btn0 = new JButton("0");
		btn0.setBackground(Color.LIGHT_GRAY);
		btn0.setBounds(1170, 619, 48, 22);
		contentPane.add(btn0);

		JButton btnJogo = new JButton("#");
		btnJogo.setBackground(Color.LIGHT_GRAY);
		btnJogo.setBounds(1231, 619, 48, 22);
		contentPane.add(btnJogo);

		JButton btnAs = new JButton("*");
		btnAs.setBackground(Color.LIGHT_GRAY);
		btnAs.setBounds(1111, 619, 48, 22);
		contentPane.add(btnAs);

		JButton btnVermelho = new JButton("");
		btnVermelho.setIcon(new ImageIcon("C:\\Users\\Esteves\\Downloads\\cancelar.png"));
		btnVermelho.setBackground(new Color(220, 20, 60));
		btnVermelho.setBounds(1111, 648, 50, 22);
		contentPane.add(btnVermelho);

		JButton btn1 = new JButton("1");
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.setBounds(1111, 530, 48, 22);
		contentPane.add(btn1);
//aaa
		JButton btn8 = new JButton("8");
		btn8.setBackground(Color.LIGHT_GRAY);
		btn8.setBounds(1170, 590, 48, 22);
		contentPane.add(btn8);

		JButton btn9 = new JButton("9");
		btn9.setBackground(Color.LIGHT_GRAY);
		btn9.setBounds(1231, 590, 48, 22);
		contentPane.add(btn9);

		JButton btn7 = new JButton("7");
		btn7.setBackground(Color.LIGHT_GRAY);
		btn7.setBounds(1111, 589, 48, 22);
		contentPane.add(btn7);

		JButton btn2 = new JButton("2");
		btn2.setBackground(Color.LIGHT_GRAY);
		btn2.setBounds(1170, 530, 48, 22);
		contentPane.add(btn2);

		JButton btn3 = new JButton("3");
		btn3.setBackground(Color.LIGHT_GRAY);
		btn3.setBounds(1231, 530, 48, 22);
		contentPane.add(btn3);

		JButton btn4 = new JButton("4");

		btn4.setBackground(Color.LIGHT_GRAY);
		btn4.setBounds(1110, 559, 48, 22);
		contentPane.add(btn4);

		JButton btn5 = new JButton("5");
		btn5.setBackground(Color.LIGHT_GRAY);
		btn5.setBounds(1170, 559, 48, 22);
		contentPane.add(btn5);

		lblConta = new JLabel("Conta:");
		lblConta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConta.setForeground(Color.WHITE);
		lblConta.setBackground(Color.WHITE);
		lblConta.setBounds(822, 424, 90, 14);
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
		lblValor.setBounds(1140, 398, 113, 15);
		contentPane.add(lblValor);

		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(1145, 423, 97, 20);
		contentPane.add(txtValor);

		lblNomeRecibo = new JLabel("Cliente: Lucas Esteves");
		lblNomeRecibo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeRecibo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNomeRecibo.setForeground(Color.DARK_GRAY);
		lblNomeRecibo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomeRecibo.setBounds(1117, 279, 151, 17);
		contentPane.add(lblNomeRecibo);

		imgMaquina = new JLabel("");
		imgMaquina.setBackground(Color.WHITE);
		imgMaquina.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\BANKEND\\maquinaComfundo.png"));
		imgMaquina.setBounds(921, -424, 1026, 1913);
		contentPane.add(imgMaquina);

		lbl1 = new JLabel("Conta:");
		lbl1.setForeground(Color.WHITE);
		lbl1.setBackground(Color.WHITE);
		lbl1.setBounds(797, 331, 158, 14);
		contentPane.add(lbl1);

		txtCartao = new JTextField();
		txtCartao.setColumns(10);
		txtCartao.setBounds(795, 348, 160, 20);
		contentPane.add(txtCartao);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\card222323.png"));
		lblNewLabel.setBounds(512, 143, 638, 365);
		contentPane.add(lblNewLabel);

		lblSair = new JLabel("");

		lblSair.setIcon(new ImageIcon("C:\\Users\\Esteves\\Downloads\\botao-de-seta-para-a-esquerda-do-teclado.png"));
		lblSair.setBounds(14, 642, 59, 53);
		contentPane.add(lblSair);

		// componentes do caixa eletronico
		lblCaixaSaldo = new JLabel("10000");
		lblCaixaSaldo.setForeground(new Color(0, 128, 0));
		lblCaixaSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaixaSaldo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCaixaSaldo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCaixaSaldo.setBounds(241, 393, 113, 14);
		contentPane.add(lblCaixaSaldo);

		lblCaixaEletronico = new JLabel("Saldo Atual");
		lblCaixaEletronico.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCaixaEletronico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaixaEletronico.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCaixaEletronico.setBounds(239, 367, 120, 33);
		contentPane.add(lblCaixaEletronico);

		ImgBackground = new JLabel("");
		ImgBackground.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\2133232232323.jpg"));
		ImgBackground.setBounds(0, 0, 1375, 705);
		contentPane.add(ImgBackground);

		// setando visibilidade dos components
		lblNome.setVisible(false);
		lblConta.setVisible(false);
		lblNomeRecibo.setVisible(false);
		lblValor.setVisible(false);
		txtValor.setVisible(false);
		lblAgencia.setVisible(false);

		// convertendo para string e limitando as casas
		String caixaSaldo = String.format("%.2f", contaRemetente.getSaldo());
		lblCaixaSaldo.setText(caixaSaldo + "$");

		Query bd = new Query(con);

		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				MenuTransacaos transacaos = new MenuTransacaos(conexao, contaRemetente);

				transacaos.setVisible(true);
				dispose();
			}
		});

		btnAmarelo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				txtValor.setText("");

			}
		});

		btnVermelho.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Transferencia reabrir = new Transferencia(conexao, contaRemetente);
				reabrir.setVisible(true);
				dispose();

			}
		});

		// verifica se a conta existe

		btnVerificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// se o campo for vzio
				if (txtCartao.getText().trim().equals("")) {

					JOptionPane.showMessageDialog(null, "Conta Invalida!!", "#ERRO404", JOptionPane.ERROR_MESSAGE);
					txtCartao.setBorder(new LineBorder(Color.RED));
					txtCartao.setBorder(new LineBorder(Color.RED));

				} else {
					// pegando conta digitada no texto
					String numConta = txtCartao.getText();

					// se a conta informada existir
					if (bd.contaExiste(numConta)) {

						// verifica se a conta do destinatario é igual
						if (numConta.equals(contaRemetente.getNumero())) {
							JOptionPane.showMessageDialog(null, "MESMA CONTA!!", "#ERRO404", JOptionPane.ERROR_MESSAGE);

						} else {

							// metodo que retorna a conta com o cliente
							contaDestinatario = bd.verificaConta(numConta);

							// metodo pergutna se o usuario quer continuar
							if (mensagemContinuar(imgMaquina)) {
								exibeMaquininha(imgMaquina, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
										btnAs, btnVermelho, btnJogo, btnAmarelo, btnVerde);
							}

						}

					} else {
						JOptionPane.showMessageDialog(null, "Conta não cadastrada!", "#ERRO404",
								JOptionPane.ERROR_MESSAGE);
						txtCartao.setText("");
						txtCartao.setBorder(new LineBorder(Color.RED));
					}
				}

			}
		});

		// botao da maquina
		btnVerde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// se o campo de valor nao for nulo
				if (!txtValor.getText().trim().equals("")) { // metodo que confirma
					confirmarTransacao(bd);
				}

			}
		});

	}

	public boolean mensagemContinuar(JLabel imgMaquina) {

		String nome = contaDestinatario.getCliente().getNome();

		int i = JOptionPane.showConfirmDialog(null, "Destinario: " + nome + "\n \n \t \t \t  Deseja continuar?",
				"Transferencia", JOptionPane.OK_CANCEL_OPTION);

		// se clicar em sim
		if (i == JOptionPane.YES_OPTION) {

			System.out.println("Clicou em Sim");
			return true;

		}
		// se clicar em nao

		else if (i == JOptionPane.CANCEL_OPTION) {

			System.out.println("Clicou em Não");

			return false;
		}
		return false;

	}

	public void exibeMaquininha(JLabel imgMaquina, JButton btn0, JButton btn1, JButton btn2, JButton btn3, JButton btn4,
			JButton btn5, JButton btn6, JButton btn7, JButton btn8, JButton btn9, JButton btnAs, JButton btnVermelho,
			JButton btnJogo, JButton btnAmarelo, JButton btnVerde) {

		String nome1 = contaDestinatario.getCliente().getNome();
		String sobrenome = contaDestinatario.getCliente().getSobreNome();

		// setando textos
		lblConta.setText(contaDestinatario.getNumero());
		lblNome.setText(nome1 + " " + sobrenome);
		lblAgencia.setText(contaDestinatario.getAgencia());
		lblTipo.setText("Conta: " + contaDestinatario.getTipo());
		imgMaquina.setBounds(921, -538, 1026, 1913);
		// setando visibilidade dos componentes
		lblConta.setVisible(true);
		btnVerificar.setVisible(false);
		txtCartao.setVisible(false);
		lbl1.setVisible(false);
		lblNome.setVisible(true);
		lblNomeRecibo.setVisible(false);
		lblValor.setVisible(true);
		txtValor.setVisible(true);
		lbl2.setVisible(true);
		lbl3.setVisible(true);
		lblAgencia.setVisible(true);
		lblTipo.setVisible(true);

		// setando a posição dos botoes
		btn0.setBounds(1170, 505, 48, 22);
		btn1.setBounds(1111, 416, 48, 22);
		btn2.setBounds(1170, 416, 48, 22);
		btn3.setBounds(1231, 416, 48, 22);
		btn4.setBounds(1110, 445, 48, 22);
		btn5.setBounds(1170, 445, 48, 22);
		btn6.setBounds(1231, 445, 48, 22);
		btn7.setBounds(1111, 475, 48, 22);
		btn8.setBounds(1170, 476, 48, 22);
		btn9.setBounds(1231, 476, 48, 22);

		btnVermelho.setBounds(1111, 534, 50, 22);
		btnAs.setBounds(1111, 505, 48, 22);
		btnJogo.setBounds(1231, 505, 48, 22);
		btnAmarelo.setBounds(1170, 534, 48, 22);
		txtValor.setBounds(1145, 309, 97, 20);
		lblNomeRecibo.setBounds(1117, 165, 151, 17);
		lblValor.setBounds(1140, 284, 113, 15);
		btnVerde.setBounds(1231, 534, 48, 22);
	}

	public void confirmarTransacao(Query bd) {

		String nomee = contaDestinatario.getCliente().getNome();
		String sobrenome = contaDestinatario.getCliente().getSobreNome();
		String nome = nomee + " " + sobrenome;
		String valor = txtValor.getText();
		int i;

		if (contaRemetente.getTipo().equals("corrente")) {

			i = JOptionPane
					.showConfirmDialog(null,
							"\t Destinatario:" + nome + " \n \t Valor da transferencia:" + valor + "$ \n \t Taxa:0,10$ "
									+ "\n \n \t \t \t  Deseja continuar?",
							"Transferencia", JOptionPane.OK_CANCEL_OPTION);

		} else {

			i = JOptionPane.showConfirmDialog(null, "Destinatario:" + nome + " \n \t Valor da transferencia: " + valor
					+ "$\n \n \t \t \t  Deseja continuar?", "Transferencia", JOptionPane.OK_CANCEL_OPTION);

		}

		// se clicar em sim
		if (i == JOptionPane.YES_OPTION) {

			System.out.println("Clicou em Sim");
			transferencia(bd);

		}
		// se clicar em nao

		else if (i == JOptionPane.CANCEL_OPTION) {

			System.out.println("Clicou em Não");
			txtValor.setText("");
		}

	}

	public void transferencia(Query bd) {
		// pegando e convertendo valor inforamdo
		String valor = txtValor.getText();
		transferencia = Double.parseDouble(valor);

		System.out.println(valor);

		// verificando qual conta é
		if (contaRemetente.getTipo().equals("corrente")) {

			// fazend o cast
			corrente = (ContaCorrente) contaRemetente;

			System.out.println(corrente.getSaldo());

			// se o saldo for suficiente
			if (corrente.transferencia(contaDestinatario, transferencia)) {
				System.out.println(corrente.getSaldo());

				contaRemetente = corrente;

				bd.atualizarTransferencia(contaRemetente, contaDestinatario);
				caixaEletronico();

			} else {
				lblCaixaSaldo.setForeground(Color.red);
				txtValor.setBorder(new LineBorder(Color.RED));
				JOptionPane.showMessageDialog(null, "Saldo insuficiente!!", "Sucess", JOptionPane.ERROR_MESSAGE);

			}

		}
		if (contaRemetente.getTipo().equals("poupanca")) {

			poupanca = (ContaPoupanca) contaRemetente;

			// se o saldo for suficiente
			if (poupanca.transferencia(contaDestinatario, transferencia)) {

				contaRemetente = poupanca;

				bd.atualizarTransferencia(contaRemetente, contaDestinatario);
				caixaEletronico();
			} else {
				lblCaixaSaldo.setForeground(Color.red);
				txtValor.setBorder(new LineBorder(Color.RED));
				JOptionPane.showMessageDialog(null, "Saldo insuficiente!!", "Sucess", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public void caixaEletronico() {
		// convertendo para string e limitando as casas
		lblCaixaSaldo.setForeground(new Color(0, 128, 0));
		String caixaSaldo = String.format("%.2f", contaRemetente.getSaldo());
		lblCaixaSaldo.setText(caixaSaldo + "$");

		System.out.println("Transferencia de " + transferencia + "$ feito com suceso!!");
		exibeCupomFiscal();
		JOptionPane.showMessageDialog(null, "Transferencia de " + txtValor.getText() + "$ feito com suceso!!", "Sucess",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public void exibeCupomFiscal() {
		geraComprovante();
		lblValor.setVisible(false);
		txtValor.setVisible(false);
		txtValor.setText("");

		String nome1 = contaDestinatario.getCliente().getNome();
		String sobrenome = contaDestinatario.getCliente().getSobreNome();

		imgMaquina.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\BANKEND\\macahdoo98.png"));
		lblCupomNome.setText("Titular:" + nome1 + " " + sobrenome);
		lblCupomContaa.setText("Conta:"+contaDestinatario.getNumero());
		lblCupomFavorecido.setText("Favorecido");
		lblCupomTipoConta.setText("Transferencia em Conta: Corrente");
		lblCupomAgencia.setText("Agencia:"+contaDestinatario.getAgencia());
	}



	public void geraComprovante()
	{
		try {
			Comprovante.Transferencia(contaDestinatario,transferencia);
		} catch (IOException e) {
			System.out.println("erro ao gerar o comprovante");
			e.printStackTrace();
		}
	}
	





}
