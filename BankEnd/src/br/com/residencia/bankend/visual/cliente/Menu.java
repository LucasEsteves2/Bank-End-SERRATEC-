package br.com.residencia.bankend.visual.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import br.com.residencia.bankend.contas.Contas;
import br.com.residencia.bankend.visual.TelaLogin;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Contas conta;
	private Connection con;

	public Menu(Connection con, Contas conta) {
		this.conta = conta;
		this.con = con;
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/br/com/residencia/bankend/imagens/banco.png")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(Menu.class.getResource("/br/com/residencia/bankend/imagens/logo.png")));
		lblLogo.setBounds(0, 0, 238, 130);
		contentPane.add(lblLogo);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(-6, -14, 238, 736);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel painelSeguro = new JPanel();

		painelSeguro.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		painelSeguro.setBounds(-1, 252, 243, 56);
		painelSeguro.setBackground(Color.WHITE);
		panel.add(painelSeguro);
		painelSeguro.setLayout(null);

		JLabel imgPaciente = new JLabel("");
		imgPaciente.setHorizontalTextPosition(SwingConstants.CENTER);
		imgPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		imgPaciente.setIcon(new ImageIcon(Menu.class.getResource("/br/com/residencia/bankend/imagens/seguro-de-vida.png")));
		imgPaciente.setBounds(23, 12, 32, 32);
		painelSeguro.add(imgPaciente);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(79, 16, 0, 0);
		painelSeguro.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(new Color(0, 255, 0));

		JLabel txtMedico = new JLabel("Seguro de vida");
		txtMedico.setHorizontalTextPosition(SwingConstants.CENTER);
		txtMedico.setHorizontalAlignment(SwingConstants.CENTER);
		txtMedico.setBounds(68, 16, 114, 22);
		txtMedico.setFont(new Font("Segoe UI", Font.BOLD, 16));
		painelSeguro.add(txtMedico);

		Panel PainelVoltar = new Panel();
		PainelVoltar.setBackground(new Color(248, 248, 255));
		PainelVoltar.setBounds(235, 0, 1139, 26);
		contentPane.add(PainelVoltar);
		PainelVoltar.setLayout(null);

		JLabel lblInicio = new JLabel("");

		lblInicio.setIcon(
				new ImageIcon(Menu.class.getResource("/br/com/residencia/bankend/imagens/pagina-inicial (1).png")));
		lblInicio.setBounds(10, -1, 29, 30);
		PainelVoltar.add(lblInicio);

		JLabel lblNewLabel_5 = new JLabel("Home");
		lblNewLabel_5.setForeground(UIManager.getColor("Button.foreground"));
		lblNewLabel_5.setBackground(new Color(0, 0, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(37, 10, 46, 14);
		PainelVoltar.add(lblNewLabel_5);

		JPanel PainelFechar = new JPanel();
		PainelFechar.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		PainelFechar.setLayout(null);
		PainelFechar.setBackground(Color.WHITE);
		PainelFechar.setBounds(-1, 308, 246, 56);
		panel.add(PainelFechar);

		JLabel imgPaciente_1_1_1 = new JLabel("");
		imgPaciente_1_1_1
				.setIcon(new ImageIcon(Menu.class.getResource("/br/com/residencia/bankend/imagens/cancelar.png")));
		imgPaciente_1_1_1.setBounds(23, 12, 32, 32);
		PainelFechar.add(imgPaciente_1_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1.setBackground(Color.GREEN);
		lblNewLabel_2_1_1_1.setBounds(79, 16, 0, 0);
		PainelFechar.add(lblNewLabel_2_1_1_1);

		JLabel txtMedico_1_1_1 = new JLabel("SAIR");
		txtMedico_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtMedico_1_1_1.setBounds(68, 16, 90, 22);
		PainelFechar.add(txtMedico_1_1_1);

		JPanel painelConta = new JPanel();
		painelConta.setBorder(new MatteBorder(2, 1, 1, 1, (Color) new Color(0, 0, 0)));
		painelConta.setLayout(null);
		painelConta.setBackground(Color.WHITE);
		painelConta.setBounds(-1, 140, 246, 56);
		panel.add(painelConta);

		JLabel imgPaciente_1_1 = new JLabel("");
		imgPaciente_1_1.setIcon(new ImageIcon(Menu.class.getResource("/br/com/residencia/bankend/imagens/cartao-de-credito (1).png")));
		imgPaciente_1_1.setBounds(23, 12, 32, 32);
		painelConta.add(imgPaciente_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setBackground(Color.GREEN);
		lblNewLabel_2_1_1.setBounds(79, 16, 0, 0);
		painelConta.add(lblNewLabel_2_1_1);

		JLabel txtMedico_1_1 = new JLabel("Minha Conta");
		txtMedico_1_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtMedico_1_1.setBounds(68, 16, 115, 22);
		painelConta.add(txtMedico_1_1);

		JPanel painelTransacao = new JPanel();

		painelTransacao.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		painelTransacao.setLayout(null);
		painelTransacao.setBackground(Color.WHITE);
		painelTransacao.setBounds(-1, 196, 245, 56);
		panel.add(painelTransacao);

		JLabel imgPaciente_1 = new JLabel("");
		imgPaciente_1.setIcon(new ImageIcon(Menu.class.getResource("/br/com/residencia/bankend/imagens/atm.png")));
		imgPaciente_1.setBounds(23, 12, 32, 32);
		painelTransacao.add(imgPaciente_1);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBackground(Color.GREEN);
		lblNewLabel_2_1.setBounds(79, 16, 0, 0);
		painelTransacao.add(lblNewLabel_2_1);

		JLabel txtMedico_1 = new JLabel("Transa\u00E7\u00F5es");
		txtMedico_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtMedico_1.setBounds(68, 16, 103, 22);
		painelTransacao.add(txtMedico_1);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(
				new ImageIcon(Menu.class.getResource("/br/com/residencia/bankend/imagens/Sem T\u00EDtulo-3.jpg")));
		lblBackground.setBounds(235, 28, 1139, 677);
		contentPane.add(lblBackground);


		// verifica se o cliente logado tem seguro de vida

		if (conta.getSeguro() == null) {
			cadastraSeguro();

		} else {
			System.out.println("seguro de vida caralho");
		}

		// Click no botao Conta
		painelConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MinhaConta telaConta = new MinhaConta(con, conta);
				telaConta.setVisible(true);
				dispose();
			}
		});

		// evento click botao transferencia

		painelTransacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				MenuTransacaos telaTransacao = new MenuTransacaos(con, conta);
				telaTransacao.setVisible(true);
				dispose();
			}
		});

		// escutador btn Seguro
		painelSeguro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaSeguroVida seguro = new TelaSeguroVida(conta, con);
				seguro.setLocationRelativeTo(null);
				seguro.setVisible(true);
			}
		});

		// btn fechar
		PainelFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int i = JOptionPane.showConfirmDialog(null, "Deseja Encerrar o programa?", "Finalizar",
						JOptionPane.OK_CANCEL_OPTION);

				if (i == JOptionPane.YES_OPTION) {
					System.out.println("Clicou em Sim");

					TelaLogin login = new TelaLogin(con);
					login.setVisible(true);
					dispose();

				} else if (i == JOptionPane.CANCEL_OPTION) {

					System.out.println("Clicou em Não");

				}
			}
		});

	}

	public void cadastraSeguro() {

		int i = JOptionPane.showConfirmDialog(null, "Deseja criar um seguro de vida?", "BANK END",
				JOptionPane.OK_CANCEL_OPTION);

		// se clicar em sim
		if (i == JOptionPane.YES_OPTION) {

			System.out.println("Clicou em Sim");
			TelaSeguroVida telaSeguro = new TelaSeguroVida(conta, con);
			telaSeguro.setVisible(true);

		}
		// se clicar em nao

		else if (i == JOptionPane.CANCEL_OPTION) {

			System.out.println("Clicou em Não");

		}

	}

}