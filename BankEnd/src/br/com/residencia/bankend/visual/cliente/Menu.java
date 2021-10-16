package br.com.residencia.bankend.visual.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import br.com.residencia.bankend.contas.Contas;
import br.com.residencia.bankend.utility.Mouse;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Menu(Connection con, Contas conta) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Menu.class.getResource("/br/com/residencia/bankend/imagens/hospital.png")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(-6, -14, 238, 736);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblLogo = new JLabel("New label");
		lblLogo.setBounds(-55, 11, 421, 130);
		lblLogo.setIcon(new ImageIcon(Menu.class.getResource("/br/com/residencia/bankend/imagens/asx.png")));
		panel.add(lblLogo);

		JPanel painelSeguro = new JPanel();

		painelSeguro.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		painelSeguro.setBounds(-1, 252, 243, 56);
		painelSeguro.setBackground(Color.WHITE);
		panel.add(painelSeguro);
		painelSeguro.setLayout(null);

		JLabel imgPaciente = new JLabel("");
		imgPaciente.setHorizontalTextPosition(SwingConstants.CENTER);
		imgPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		imgPaciente.setIcon(new ImageIcon(Menu.class.getResource("/br/com/residencia/bankend/imagens/doctor (4).png")));
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
		imgPaciente_1_1
				.setIcon(new ImageIcon(Menu.class.getResource("/br/com/residencia/bankend/imagens/health-check.png")));
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

		JPanel painelTransferencia = new JPanel();

		painelTransferencia.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		painelTransferencia.setLayout(null);
		painelTransferencia.setBackground(Color.WHITE);
		painelTransferencia.setBounds(-1, 196, 245, 56);
		panel.add(painelTransferencia);

		JLabel imgPaciente_1 = new JLabel("");
		imgPaciente_1
				.setIcon(new ImageIcon(Menu.class.getResource("/br/com/residencia/bankend/imagens/examination.png")));
		imgPaciente_1.setBounds(23, 12, 32, 32);
		painelTransferencia.add(imgPaciente_1);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBackground(Color.GREEN);
		lblNewLabel_2_1.setBounds(79, 16, 0, 0);
		painelTransferencia.add(lblNewLabel_2_1);

		JLabel txtMedico_1 = new JLabel("Transferencia");
		txtMedico_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtMedico_1.setBounds(68, 16, 103, 22);
		painelTransferencia.add(txtMedico_1);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(
				new ImageIcon(Menu.class.getResource("/br/com/residencia/bankend/imagens/backgroundvddd.jpg")));
		lblBackground.setBounds(235, 28, 1134, 711);
		contentPane.add(lblBackground);

		JLabel lblMenu = new JLabel("New label");
		lblMenu.setIcon(new ImageIcon(Menu.class.getResource("/br/com/residencia/bankend/imagens/2.jpg")));
		lblMenu.setBounds(6, 11, 232, 714);
		panel.add(lblMenu);

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

				Transferencia telaTransferencia = new Transferencia(con,conta);

				telaTransferencia.setVisible(true);

			}
		});

		painelConta.addMouseListener(new Mouse(painelConta));

	}
}