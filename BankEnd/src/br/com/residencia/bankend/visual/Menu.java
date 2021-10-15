package br.com.residencia.bankend.visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.border.MatteBorder;

import br.com.residencia.bankend.bd.Query;
import br.com.residencia.bankend.clientes.Cliente;
import br.com.residencia.bankend.contas.Contas;
import br.com.residencia.bankend.utility.Mouse;

import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Label;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.JComboBox;

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
		lblLogo.setBounds(-55, -34, 421, 225);
		lblLogo.setIcon(new ImageIcon(Menu.class.getResource("/br/com/residencia/bankend/imagens/asx.png")));
		panel.add(lblLogo);

		JPanel PainelMedico = new JPanel();

		PainelMedico.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		PainelMedico.setBounds(-1, 252, 243, 56);
		PainelMedico.setBackground(Color.WHITE);
		panel.add(PainelMedico);
		PainelMedico.setLayout(null);

		JLabel imgPaciente = new JLabel("");
		imgPaciente.setHorizontalTextPosition(SwingConstants.CENTER);
		imgPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		imgPaciente.setIcon(new ImageIcon(Menu.class.getResource("/br/com/residencia/bankend/imagens/doctor (4).png")));
		imgPaciente.setBounds(23, 12, 32, 32);
		PainelMedico.add(imgPaciente);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(79, 16, 0, 0);
		PainelMedico.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(new Color(0, 255, 0));

		JLabel txtMedico = new JLabel("SALDO");
		txtMedico.setHorizontalTextPosition(SwingConstants.CENTER);
		txtMedico.setHorizontalAlignment(SwingConstants.CENTER);
		txtMedico.setBounds(68, 16, 112, 22);
		txtMedico.setFont(new Font("Segoe UI", Font.BOLD, 16));
		PainelMedico.add(txtMedico);

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

		JPanel PainelConsulta = new JPanel();
		PainelConsulta.setBorder(new MatteBorder(2, 1, 1, 1, (Color) new Color(0, 0, 0)));
		PainelConsulta.setLayout(null);
		PainelConsulta.setBackground(Color.WHITE);
		PainelConsulta.setBounds(-1, 140, 246, 56);
		panel.add(PainelConsulta);

		JLabel imgPaciente_1_1 = new JLabel("");
		imgPaciente_1_1
				.setIcon(new ImageIcon(Menu.class.getResource("/br/com/residencia/bankend/imagens/health-check.png")));
		imgPaciente_1_1.setBounds(23, 12, 32, 32);
		PainelConsulta.add(imgPaciente_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setBackground(Color.GREEN);
		lblNewLabel_2_1_1.setBounds(79, 16, 0, 0);
		PainelConsulta.add(lblNewLabel_2_1_1);

		JLabel txtMedico_1_1 = new JLabel("Deposito");
		txtMedico_1_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtMedico_1_1.setBounds(68, 16, 115, 22);
		PainelConsulta.add(txtMedico_1_1);

		JPanel PainelPaciente = new JPanel();
		PainelPaciente.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		PainelPaciente.setLayout(null);
		PainelPaciente.setBackground(Color.WHITE);
		PainelPaciente.setBounds(-1, 196, 245, 56);
		panel.add(PainelPaciente);

		JLabel imgPaciente_1 = new JLabel("");
		imgPaciente_1
				.setIcon(new ImageIcon(Menu.class.getResource("/br/com/residencia/bankend/imagens/examination.png")));
		imgPaciente_1.setBounds(23, 12, 32, 32);
		PainelPaciente.add(imgPaciente_1);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBackground(Color.GREEN);
		lblNewLabel_2_1.setBounds(79, 16, 0, 0);
		PainelPaciente.add(lblNewLabel_2_1);

		JLabel txtMedico_1 = new JLabel("Transferencia");
		txtMedico_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtMedico_1.setBounds(68, 16, 103, 22);
		PainelPaciente.add(txtMedico_1);
		
		Panel panel_1 = new Panel();
	
		panel_1.setBackground(UIManager.getColor("CheckBox.background"));
		panel_1.setBounds(235, 32, 1142, 675);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Panel panel_2 = new Panel();
		panel_2.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 12));
		panel_2.setBounds(38, 148, 328, 120);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		
		Label label = new Label("Conta:");
		label.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 22));
		label.setBounds(11, 9, 113, 30);
		panel_2.add(label);
		
		JLabel lblNewLabel = new JLabel("1234");
		lblNewLabel.setForeground(SystemColor.inactiveCaption);
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 29));
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setBounds(17, 63, 98, 46);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("AGENCIA");
		lblNewLabel_3.setBounds(33, 51, 46, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("12345678-9");
		lblNewLabel_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_4.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 30));
		lblNewLabel_4.setBackground(Color.GREEN);
		lblNewLabel_4.setBounds(121, 61, 210, 46);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("NUMERO DA CONTA");
		lblNewLabel_3_1.setBounds(166, 49, 98, 14);
		panel_2.add(lblNewLabel_3_1);
		
		Panel panel_2_1 = new Panel();
		panel_2_1.setLayout(null);
		panel_2_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 12));
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(399, 148, 328, 120);
		panel_1.add(panel_2_1);
		
		Label label_1 = new Label("Status:");
		label_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 22));
		label_1.setBounds(11, 10, 126, 34);
		panel_2_1.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("ATIVO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(153, 0, 204));
		lblNewLabel_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 37));
		lblNewLabel_1.setBackground(Color.GREEN);
		lblNewLabel_1.setBounds(3, 48, 325, 46);
		panel_2_1.add(lblNewLabel_1);
		
		Panel panel_2_1_1 = new Panel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 12));
		panel_2_1_1.setBackground(Color.WHITE);
		panel_2_1_1.setBounds(764, 148, 328, 120);
		panel_1.add(panel_2_1_1);
		
		Label label_1_1 = new Label("Saldo total:");
		label_1_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 22));
		label_1_1.setBounds(12, 10, 126, 34);
		panel_2_1_1.add(label_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("R$ - - - - - - -");
		lblNewLabel_1_1.setForeground(new Color(34, 139, 34));
		lblNewLabel_1_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 39));
		lblNewLabel_1_1.setBackground(Color.GREEN);
		lblNewLabel_1_1.setBounds(26, 49, 210, 46);
		panel_2_1_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_8 = new JLabel("R$ : ***");
		lblNewLabel_8.setForeground(new Color(255, 102, 0));
		lblNewLabel_8.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 19));
		lblNewLabel_8.setBounds(943, 55, 91, 22);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("Saldo:");
		lblNewLabel_7.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 19));
		lblNewLabel_7.setBounds(884, 54, 69, 23);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 153, 51), null));
		lblNewLabel_6.setBounds(871, 40, 188, 50);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_9 = new JLabel("Status");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_9.setBounds(82, 416, 52, 23);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("Nome do Cliente");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_9_1.setBounds(239, 416, 131, 22);
		panel_1.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_10 = new JLabel("ATIVO");
		lblNewLabel_10.setForeground(new Color(0, 102, 51));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10.setBounds(83, 466, 40, 16);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Lucas Esteves");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(244, 464, 213, 19);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_11_1 = new JLabel("Natalino Esteves");
		lblNewLabel_11_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11_1.setBounds(244, 516, 153, 14);
		panel_1.add(lblNewLabel_11_1);
		
		JLabel lblNewLabel_10_1 = new JLabel("ATIVO");
		lblNewLabel_10_1.setForeground(new Color(0, 102, 51));
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10_1.setBounds(82, 516, 40, 16);
		panel_1.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("Saldo");
		lblNewLabel_9_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_9_1_1.setBounds(473, 417, 131, 22);
		panel_1.add(lblNewLabel_9_1_1);
		
		JLabel lblNewLabel_12 = new JLabel("R$  950,00");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(461, 464, 69, 17);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_12_1 = new JLabel("R$  920,00");
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_12_1.setBounds(461, 515, 69, 17);
		panel_1.add(lblNewLabel_12_1);
		
		JLabel lblNewLabel_13 = new JLabel("HISTORICO ");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_13.setBounds(516, 346, 91, 20);
		panel_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon("C:\\Users\\Esteves\\Downloads\\seo.png"));
		lblNewLabel_14.setBounds(1026, 48, 82, 32);
		panel_1.add(lblNewLabel_14);

		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\bg.png"));
		lblBackground.setBounds(235, 28, 1134, 711);
		contentPane.add(lblBackground);

		// ANIMAÇÃO AO PASSAR O MOUSE ( Escutador de click-mouse)
		/*
		 * PainelMedico.addMouseListener(new MouseFunction(PainelMedico, "medico", this,
		 * con)); PainelConsulta.addMouseListener(new MouseFunction(PainelConsulta,
		 * "consulta", this, con)); PainelPaciente.addMouseListener(new
		 * MouseFunction(PainelPaciente, "paciente", this, con));
		 * PainelFechar.addMouseListener(new MouseFunction(PainelFechar, "fechar", this,
		 * con));
		 */
		
		JLabel lblMenu = new JLabel("New label");
		lblMenu.setIcon(new ImageIcon(Menu.class.getResource("/br/com/residencia/bankend/imagens/2.jpg")));
		lblMenu.setBounds(6, 11, 232, 714);
		panel.add(lblMenu);

		

		PainelMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Saldo kk = new Saldo(conta);

				kk.setVisible(true);

			}
		});

		PainelConsulta.addMouseListener(new Mouse(PainelConsulta));

	}
}