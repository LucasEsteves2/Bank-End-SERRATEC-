package br.com.residencia.bankend.visual.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import br.com.residencia.bankend.contas.Contas;
import br.com.residencia.bankend.visual.TelaLogin;
import javax.swing.JButton;

public class MinhaConta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Connection con;
	private Contas conta;
	private JPanel painelSeguro;
	private JPanel painelConta;
	private JPanel painelTransferencia;

	public MinhaConta(Connection con, Contas conta) {

		this.conta = conta;
		this.con = con;

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Esteves\\Downloads\\banco.png"));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//ola
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(-6, -14, 238, 736);
		contentPane.add(panel);
		panel.setLayout(null);

		painelSeguro = new JPanel();

		painelSeguro.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		painelSeguro.setBounds(-1, 252, 243, 56);
		painelSeguro.setBackground(Color.WHITE);
		panel.add(painelSeguro);
		painelSeguro.setLayout(null);

		JLabel imgPaciente = new JLabel("");
		imgPaciente.setHorizontalTextPosition(SwingConstants.CENTER);
		imgPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		imgPaciente.setIcon(
				new ImageIcon("C:\\Users\\Esteves\\Downloads\\seguro-de-vida.png"));
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

		lblInicio.setIcon(new ImageIcon(
				MinhaConta.class.getResource("/br/com/residencia/bankend/imagens/pagina-inicial (1).png")));
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
		imgPaciente_1_1_1.setIcon(
				new ImageIcon(MinhaConta.class.getResource("/br/com/residencia/bankend/imagens/cancelar.png")));
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

		painelConta = new JPanel();
		painelConta.setBorder(new MatteBorder(2, 1, 1, 1, (Color) new Color(0, 0, 0)));
		painelConta.setLayout(null);
		painelConta.setBackground(Color.LIGHT_GRAY);
		painelConta.setBounds(-1, 140, 246, 56);
		panel.add(painelConta);

		JLabel imgPaciente_1_1 = new JLabel("");
		imgPaciente_1_1.setIcon(
				new ImageIcon("C:\\Users\\Esteves\\Downloads\\cartao-de-credito (1).png"));
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
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(10, -180, 421, 225);
		painelConta.add(lblLogo);
		lblLogo.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\BANKEND\\mauqina\\logo2.png"));

		painelTransferencia = new JPanel();
		painelTransferencia.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		painelTransferencia.setLayout(null);
		painelTransferencia.setBackground(Color.WHITE);
		painelTransferencia.setBounds(-1, 196, 245, 56);
		panel.add(painelTransferencia);

		JLabel imgPaciente_1 = new JLabel("");
		imgPaciente_1.setIcon(
				new ImageIcon("C:\\Users\\Esteves\\Downloads\\atm.png"));
		imgPaciente_1.setBounds(23, 12, 32, 32);
		painelTransferencia.add(imgPaciente_1);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBackground(Color.GREEN);
		lblNewLabel_2_1.setBounds(79, 16, 0, 0);
		painelTransferencia.add(lblNewLabel_2_1);

		JLabel txtMedico_1 = new JLabel("Transa\u00E7\u00F5es");
		txtMedico_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtMedico_1.setBounds(68, 16, 103, 22);
		painelTransferencia.add(txtMedico_1);
		
		JLabel lblLogo_1 = new JLabel("");
		lblLogo_1.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\BANKEND\\mauqina\\logo.png"));
		lblLogo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo_1.setBounds(4, 11, 238, 130);
		panel.add(lblLogo_1);

		Panel lblSobrenome = new Panel();

		lblSobrenome.setBackground(UIManager.getColor("CheckBox.background"));
		lblSobrenome.setBounds(235, 28, 1142, 679);
		contentPane.add(lblSobrenome);
		lblSobrenome.setLayout(null);

		Panel panel_2 = new Panel();
		panel_2.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 12));
		panel_2.setBounds(38, 148, 328, 120);
		lblSobrenome.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);

		Label label = new Label("Conta:");
		label.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 22));
		label.setBounds(11, 9, 113, 30);
		panel_2.add(label);

		JLabel lblAgencia = new JLabel("1234");
		lblAgencia.setForeground(SystemColor.inactiveCaption);
		lblAgencia.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 29));
		lblAgencia.setBackground(Color.GREEN);
		lblAgencia.setBounds(17, 63, 98, 46);
		panel_2.add(lblAgencia);

		JLabel lblNewLabel_3 = new JLabel("AGENCIA");
		lblNewLabel_3.setBounds(33, 51, 46, 14);
		panel_2.add(lblNewLabel_3);

		JLabel lblNumConta = new JLabel("12345678-9");
		lblNumConta.setForeground(SystemColor.textHighlight);
		lblNumConta.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 30));
		lblNumConta.setBackground(Color.GREEN);
		lblNumConta.setBounds(121, 61, 210, 46);
		panel_2.add(lblNumConta);

		JLabel lblNewLabel_3_1 = new JLabel("NUMERO DA CONTA");
		lblNewLabel_3_1.setBounds(151, 49, 113, 14);
		panel_2.add(lblNewLabel_3_1);

		Panel panel_2_1 = new Panel();
		panel_2_1.setLayout(null);
		panel_2_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 12));
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(399, 148, 328, 120);
		lblSobrenome.add(panel_2_1);

		Label label_1 = new Label("Status:");
		label_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 22));
		label_1.setBounds(11, 10, 126, 34);
		panel_2_1.add(label_1);

		JLabel lblStatus = new JLabel("ATIVO");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setForeground(new Color(153, 0, 204));
		lblStatus.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 37));
		lblStatus.setBackground(Color.GREEN);
		lblStatus.setBounds(3, 48, 325, 46);
		panel_2_1.add(lblStatus);

		Panel panel_2_1_1 = new Panel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 12));
		panel_2_1_1.setBackground(Color.WHITE);
		panel_2_1_1.setBounds(764, 148, 328, 120);
		lblSobrenome.add(panel_2_1_1);

		Label label_1_1 = new Label("Saldo total:");
		label_1_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 22));
		label_1_1.setBounds(12, 10, 126, 34);
		panel_2_1_1.add(label_1_1);

		JLabel lblSaldo = new JLabel("R$ - - - - - - -");
		lblSaldo.setForeground(new Color(34, 139, 34));
		lblSaldo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 39));
		lblSaldo.setBackground(Color.GREEN);
		lblSaldo.setBounds(26, 49, 210, 46);
		panel_2_1_1.add(lblSaldo);

		JLabel lblDinheiro = new JLabel("R$ : ***");
		lblDinheiro.setForeground(new Color(255, 102, 0));
		lblDinheiro.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 19));
		lblDinheiro.setBounds(946, 55, 91, 22);
		lblSobrenome.add(lblDinheiro);

		JLabel lblNewLabel_7 = new JLabel("Saldo:");
		lblNewLabel_7.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 19));
		lblNewLabel_7.setBounds(884, 54, 69, 23);
		lblSobrenome.add(lblNewLabel_7);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 153, 51), null));
		lblNewLabel_6.setBounds(871, 40, 200, 50);
		lblSobrenome.add(lblNewLabel_6);

		JLabel lbls = new JLabel("Simular Rendimento");
		lbls.setVisible(false);
		lbls.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbls.setBounds(516, 346, 165, 20);
		lblSobrenome.add(lbls);

		JLabel imgExibirSaldo = new JLabel("");

		imgExibirSaldo
				.setIcon(new ImageIcon(MinhaConta.class.getResource("/br/com/residencia/bankend/imagens/visao.png")));
		imgExibirSaldo.setBounds(1034, 48, 82, 32);
		lblSobrenome.add(imgExibirSaldo);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\Esteves\\Desktop\\PSD\\aaaaaaaaaaaaaaa.jpg"));
		lblBackground.setBounds(235, 28, 1134, 711);
		contentPane.add(lblBackground);

		JLabel lblNome = new JLabel("NOMEEEEEEEEEEEEE");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(38, 105, 101, 14);
		lblSobrenome.add(lblNome);

		JLabel lblCpf = new JLabel("New label");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCpf.setBounds(275, 105, 138, 14);
		lblSobrenome.add(lblCpf);

		JLabel lblSobrenomee = new JLabel("New label");
		lblSobrenomee.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSobrenomee.setBounds(149, 105, 104, 14);
		lblSobrenome.add(lblSobrenomee);

		// ANIMAÇÃO AO PASSAR O MOUSE ( Escutador de click-mouse)

		// PainelConsulta.addMouseListener(new Mouse(PainelMedico, "medico", this,
		// con));

		/// trocando os valores da tela pelo da conta

		String saldo = String.format("%.2f", conta.getSaldo());

		lblAgencia.setText(conta.getAgencia());
		lblSaldo.setText(saldo);
		lblNumConta.setText(conta.getNumero());
		lblNome.setText(conta.getCliente().getNome());
		lblCpf.setText(conta.getCliente().getCpf());
		lblSobrenomee.setText(conta.getCliente().getSobreNome());

		JButton btnRendimento = new JButton("Simular");
		btnRendimento.setVisible(false);
		btnRendimento.setBounds(526, 377, 120, 32);
		lblSobrenome.add(btnRendimento);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\Nova pasta\\card2.png"));
		lblNewLabel.setBounds(-29, 406, 638, 365);
		lblSobrenome.add(lblNewLabel);

		btnRendimento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Rendimento rendi = new Rendimento(con, conta);
				rendi.setVisible(true);

			}
		});

		imgExibirSaldo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println("clicou");

				if (lblDinheiro.getText().equals("R$ : ***")) {
					lblDinheiro.setText("R$ :" + saldo);
					imgExibirSaldo.setIcon(new ImageIcon(
							MinhaConta.class.getResource("/br/com/residencia/bankend/imagens/eye-slash.png")));
				} else {
					lblDinheiro.setText("R$ : ***");
					imgExibirSaldo.setIcon(new ImageIcon(
							MinhaConta.class.getResource("/br/com/residencia/bankend/imagens/visao.png")));

				}

			}
		});

		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Menu menuPrincipal = new Menu(con, conta);
				menuPrincipal.setVisible(true);
				dispose();

			}
		});

		// metodo com todos os escutadores
		menu();

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

		if (conta.getTipo().equals("poupanca")) {
			btnRendimento.setVisible(true);
			lbls.setVisible(true);
		}

	}

	
	public void menu() {
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

		painelTransferencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				MenuTransacaos telaTransacao = new MenuTransacaos(con, conta);
				telaTransacao.setVisible(true);

			}
		});

		painelSeguro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Deposito telaDeposito = new Deposito(con, conta);
				telaDeposito.setVisible(true);
				dispose();
			}
		});

	}
}