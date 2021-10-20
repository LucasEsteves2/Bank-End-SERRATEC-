package br.com.residencia.bankend.visual.cliente;

import java.awt.Frame;
import java.awt.Toolkit;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.residencia.bankend.contas.ContaCorrente;
import br.com.residencia.bankend.contas.Contas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuTransacaos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ContaCorrente corrente = null;
	
	
	public MenuTransacaos(Connection conexao, Contas contaRemetente) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MenuTransacaos.class.getResource("/br/com/residencia/bankend/imagens/cadeado-trancado.png")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblVoltar = new JLabel("New label");

		lblVoltar.setIcon(new ImageIcon(MenuTransacaos.class.getResource("/br/com/residencia/bankend/imagens/botao-de-seta-para-a-esquerda-do-teclado.png")));
		lblVoltar.setBounds(0, 616, 46, 89);
		contentPane.add(lblVoltar);

		JLabel lblDeposito = new JLabel("");

		lblDeposito.setBounds(969, 56, 361, 610);
		contentPane.add(lblDeposito);

		JLabel lblSaque = new JLabel("");

		lblSaque.setBounds(528, 56, 354, 610);
		contentPane.add(lblSaque);

		JLabel lblTransferencia = new JLabel("");

		lblTransferencia.setBounds(71, 56, 361, 610);
		contentPane.add(lblTransferencia);

		JLabel ImgBackground = new JLabel("");
		ImgBackground.setIcon(new ImageIcon(MenuTransacaos.class.getResource("/br/com/residencia/bankend/imagens/backzada.jpg")));
		ImgBackground.setBounds(0, 0, 1375, 705);
		contentPane.add(ImgBackground);

		lblTransferencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println("FUI CLICADO");

				Transferencia transferencia = new Transferencia(conexao, contaRemetente);
				transferencia.setVisible(true);
				dispose();

			}
		});

		lblSaque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println("FUI CLICADO");
				Saque telaSaque = new Saque(conexao, contaRemetente);
				telaSaque.setVisible(true);
				dispose();

			}
		});

		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu inicio = new Menu(conexao, contaRemetente);
				inicio.setVisible(true);
				dispose();

			}
		});

		lblDeposito.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Deposito telaDeposito = new Deposito(conexao, contaRemetente);
				telaDeposito.setVisible(true);
				dispose();
			}
		});

	}
}
