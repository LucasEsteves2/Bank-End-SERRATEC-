package br.com.residencia.bankend.visual.funcionario;

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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import br.com.residencia.bankend.funcionarios.Funcionario;
import javax.swing.JButton;

public class MenuFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public MenuFuncionario(Connection con, Funcionario fun) {

		verificaPermissao(fun);

		// visual
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MenuFuncionario.class.getResource("/br/com/residencia/bankend/imagens/hospital.png")));
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
		lblLogo.setIcon(new ImageIcon(MenuFuncionario.class.getResource("/br/com/residencia/bankend/imagens/asx.png")));
		panel.add(lblLogo);

		Panel PainelVoltar = new Panel();
		PainelVoltar.setBackground(new Color(248, 248, 255));
		PainelVoltar.setBounds(235, 0, 1139, 26);
		contentPane.add(PainelVoltar);
		PainelVoltar.setLayout(null);

		JLabel lblInicio = new JLabel("");

		lblInicio.setIcon(new ImageIcon(
				MenuFuncionario.class.getResource("/br/com/residencia/bankend/imagens/pagina-inicial (1).png")));
		lblInicio.setBounds(10, -1, 29, 30);
		PainelVoltar.add(lblInicio);

		JLabel lblNewLabel_5 = new JLabel("Home");
		lblNewLabel_5.setForeground(UIManager.getColor("Button.foreground"));
		lblNewLabel_5.setBackground(new Color(0, 0, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(37, 10, 46, 14);
		PainelVoltar.add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("MODO ADMINISTRADOR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 7, 1129, 14);
		PainelVoltar.add(lblNewLabel);

		JPanel PainelFechar = new JPanel();
		PainelFechar.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		PainelFechar.setLayout(null);
		PainelFechar.setBackground(Color.WHITE);
		PainelFechar.setBounds(-1, 252, 246, 56);
		panel.add(PainelFechar);

		JLabel imgPaciente_1_1_1 = new JLabel("");
		imgPaciente_1_1_1.setIcon(
				new ImageIcon(MenuFuncionario.class.getResource("/br/com/residencia/bankend/imagens/cancelar.png")));
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

		JPanel painelRelatorios = new JPanel();

		painelRelatorios.setBorder(new MatteBorder(2, 1, 1, 1, (Color) new Color(0, 0, 0)));
		painelRelatorios.setLayout(null);
		painelRelatorios.setBackground(Color.WHITE);
		painelRelatorios.setBounds(-1, 140, 246, 56);
		panel.add(painelRelatorios);

		JLabel imgPaciente_1_1 = new JLabel("");
		imgPaciente_1_1.setIcon(new ImageIcon(
				MenuFuncionario.class.getResource("/br/com/residencia/bankend/imagens/health-check.png")));
		imgPaciente_1_1.setBounds(23, 12, 32, 32);
		painelRelatorios.add(imgPaciente_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setBackground(Color.GREEN);
		lblNewLabel_2_1_1.setBounds(79, 16, 0, 0);
		painelRelatorios.add(lblNewLabel_2_1_1);

		JLabel txtRelatorios = new JLabel("Relatorios");
		txtRelatorios.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtRelatorios.setBounds(68, 16, 115, 22);
		painelRelatorios.add(txtRelatorios);

		JPanel painelClientes = new JPanel();

		painelClientes.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		painelClientes.setLayout(null);
		painelClientes.setBackground(Color.WHITE);
		painelClientes.setBounds(-1, 196, 245, 56);
		panel.add(painelClientes);

		JLabel imgPaciente_1 = new JLabel("");
		imgPaciente_1.setIcon(
				new ImageIcon(MenuFuncionario.class.getResource("/br/com/residencia/bankend/imagens/examination.png")));
		imgPaciente_1.setBounds(23, 12, 32, 32);
		painelClientes.add(imgPaciente_1);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBackground(Color.GREEN);
		lblNewLabel_2_1.setBounds(79, 16, 0, 0);
		painelClientes.add(lblNewLabel_2_1);

		JLabel txtClientes = new JLabel("Clientes");
		txtClientes.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtClientes.setBounds(68, 16, 103, 22);
		painelClientes.add(txtClientes);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\BANKEND\\mauqina\\12332.jpg"));
		lblBackground.setBounds(235, 28, 1134, 711);
		contentPane.add(lblBackground);

		JLabel lblMenu = new JLabel("New label");
		lblMenu.setIcon(new ImageIcon(MenuFuncionario.class.getResource("/br/com/residencia/bankend/imagens/2.jpg")));
		lblMenu.setBounds(6, 11, 232, 714);
		panel.add(lblMenu);

		JButton button = new JButton("New button");
		button.setBounds(76, 400, 89, 23);
		panel.add(button);

		
		painelRelatorios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaRelatorios relatorio = new TelaRelatorios(con, fun);
				relatorio.setLocationRelativeTo(null);
				relatorio.setVisible(true);
			}
		});
		
		painelClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TabelaClientes clientes = new TabelaClientes(con, fun);
				clientes.setLocationRelativeTo(null);
				clientes.setVisible(true);
				
				
			}
		});

	}

	
	// teste
	public void verificaPermissao(Funcionario fun) {

		int acesso = fun.getAcesso();

		switch (acesso) {
		case 1:
			System.out.println("sou um gerente");
			break;
		case 2:
			System.out.println("sou um diretor");
			break;
		case 3:
			System.out.println("sou um presidente");
			break;
		default:
			break;
		}

	}
}