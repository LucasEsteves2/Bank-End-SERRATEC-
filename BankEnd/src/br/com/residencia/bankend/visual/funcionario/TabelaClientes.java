package br.com.residencia.bankend.visual.funcionario;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import br.com.residencia.bankend.bd.Query;
import br.com.residencia.bankend.contas.ContaCorrente;
import br.com.residencia.bankend.contas.Contas;
import br.com.residencia.bankend.utility.TableModel;

import javax.swing.UIManager;
import java.awt.ComponentOrientation;

public class TabelaClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jTabelaPaciente;
	private JTextField txtPesquisar;
	private ArrayList<Contas> pacientes = new ArrayList<>();
	private Connection con;

	TableModel paciente_tableModel = new TableModel();

	public TabelaClientes(Connection con) {
		setTitle("Pacientes");

		this.con = con;
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TabelaClientes.class.getResource("/br/com/residencia/bankend/imagens/mask_icon_134856 (2).png")));
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

		JLabel painelRelatorios = new JLabel("New label");
		painelRelatorios.setBounds(-55, -29, 421, 146);

		panel.add(painelRelatorios);

		JPanel painelSeguro = new JPanel();
		painelSeguro.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		painelSeguro.setBounds(-1, 252, 243, 56);

		painelSeguro.setBackground(Color.WHITE);
		panel.add(painelSeguro);
		painelSeguro.setLayout(null);

		JLabel imgPaciente = new JLabel("");
		imgPaciente.setHorizontalTextPosition(SwingConstants.CENTER);
		imgPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		imgPaciente.setIcon(new ImageIcon(TabelaClientes.class.getResource("/br/com/residencia/bankend/imagens/doctor (4).png")));
		imgPaciente.setBounds(23, 12, 32, 32);
		painelSeguro.add(imgPaciente);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(79, 16, 0, 0);
		painelSeguro.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(new Color(0, 255, 0));

		JLabel txtMedico = new JLabel("PROFISSIONAL");
		txtMedico.setHorizontalTextPosition(SwingConstants.CENTER);
		txtMedico.setHorizontalAlignment(SwingConstants.CENTER);
		txtMedico.setBounds(68, 16, 112, 22);
		txtMedico.setFont(new Font("Segoe UI", Font.BOLD, 16));
		painelSeguro.add(txtMedico);

		Panel PainelVoltar = new Panel();
		PainelVoltar.setBackground(new Color(248, 248, 255));
		PainelVoltar.setBounds(235, 0, 1139, 26);
		contentPane.add(PainelVoltar);
		PainelVoltar.setLayout(null);

		JLabel lblInicio = new JLabel("");

		lblInicio.setIcon(new ImageIcon(TabelaClientes.class.getResource("/br/com/residencia/bankend/imagens/pagina-inicial (1).png")));
		lblInicio.setBounds(10, -1, 29, 30);
		PainelVoltar.add(lblInicio);

		JLabel lblNewLabel_5 = new JLabel("Home");
		lblNewLabel_5.setForeground(new Color(192, 192, 192));
		lblNewLabel_5.setBackground(new Color(0, 0, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(37, 10, 46, 14);
		PainelVoltar.add(lblNewLabel_5);

		JLabel lblNewLabel_4 = new JLabel("> Paciente");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBounds(71, 10, 61, 14);
		PainelVoltar.add(lblNewLabel_4);

		JPanel PainelFechar = new JPanel();
		PainelFechar.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		PainelFechar.setLayout(null);
		PainelFechar.setBackground(Color.WHITE);
		PainelFechar.setBounds(-1, 308, 246, 56);
		panel.add(PainelFechar);

		JLabel imgPaciente_1_1_1 = new JLabel("");
		imgPaciente_1_1_1.setIcon(new ImageIcon(TabelaClientes.class.getResource("/br/com/residencia/bankend/imagens/cancelar.png")));
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
		imgPaciente_1_1.setIcon(new ImageIcon(TabelaClientes.class.getResource("/br/com/residencia/bankend/imagens/health-check.png")));
		imgPaciente_1_1.setBounds(23, 12, 32, 32);
		PainelConsulta.add(imgPaciente_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setBackground(Color.GREEN);
		lblNewLabel_2_1_1.setBounds(79, 16, 0, 0);
		PainelConsulta.add(lblNewLabel_2_1_1);

		JLabel txtMedico_1_1 = new JLabel("RELATORIOS");
		txtMedico_1_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtMedico_1_1.setBounds(68, 16, 115, 22);
		PainelConsulta.add(txtMedico_1_1);

		JPanel painelClientes = new JPanel();
		painelClientes.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		painelClientes.setLayout(null);
		painelClientes.setBackground(new Color(240, 248, 255));
		painelClientes.setBounds(-1, 196, 245, 56);
		panel.add(painelClientes);

		JLabel imgPaciente_1 = new JLabel("");
		imgPaciente_1.setIcon(new ImageIcon(TabelaClientes.class.getResource("/br/com/residencia/bankend/imagens/examination.png")));
		imgPaciente_1.setBounds(23, 12, 32, 32);
		painelClientes.add(imgPaciente_1);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBackground(Color.GREEN);
		lblNewLabel_2_1.setBounds(79, 16, 0, 0);
		painelClientes.add(lblNewLabel_2_1);

		JLabel txtMedico_1 = new JLabel("CLIENTES");
		txtMedico_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtMedico_1.setBounds(68, 16, 90, 22);
		painelClientes.add(txtMedico_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(235, 30, 1139, 692);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 96, 1070, 535);
		panel_1.add(scrollPane);

		jTabelaPaciente = new JTable();

		scrollPane.setViewportView(jTabelaPaciente);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(TabelaClientes.class.getResource("/br/com/residencia/bankend/imagens/trash.png")));
		btnExcluir.setBounds(255, 36, 90, 34);
		panel_1.add(btnExcluir);

		JLabel lblPesquisarr = new JLabel("Pesquisar:");
		lblPesquisarr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPesquisarr.setBounds(356, 43, 67, 17);
		panel_1.add(lblPesquisarr);

		txtPesquisar = new JTextField();

		txtPesquisar.setBounds(424, 36, 530, 34);
		panel_1.add(txtPesquisar);
		txtPesquisar.setColumns(10);

		btnExcluir.setBackground(new java.awt.Color(0, 102, 52));
		btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
		btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
		btnExcluir.setBorder(null);
		btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		btnExcluir.setDoubleBuffered(true);

		JButton btnEditar = new JButton("Editar");
		
		btnEditar.setIcon(new ImageIcon(TabelaClientes.class.getResource("/br/com/residencia/bankend/imagens/edit.png")));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnEditar.setDoubleBuffered(true);
		btnEditar.setBorder(null);
		btnEditar.setBackground(new Color(0, 102, 52));
		btnEditar.setBounds(144, 36, 90, 35);
		panel_1.add(btnEditar);

		JButton btnNovo = new JButton("Novo");
		btnNovo.setIcon(new ImageIcon(TabelaClientes.class.getResource("/br/com/residencia/bankend/imagens/plus-black-symbol.png")));
		btnNovo.setForeground(Color.WHITE);
		btnNovo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnNovo.setDoubleBuffered(true);
		btnNovo.setBorder(null);
		btnNovo.setBackground(new Color(0, 102, 52));
		btnNovo.setBounds(33, 36, 90, 35);
		panel_1.add(btnNovo);

		JButton btnPesquisar = new JButton("Pesquisar");
		
		btnPesquisar.setIcon(new ImageIcon(TabelaClientes.class.getResource("/br/com/residencia/bankend/imagens/search.png")));
		btnPesquisar.setForeground(Color.WHITE);
		btnPesquisar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnPesquisar.setDoubleBuffered(true);
		btnPesquisar.setBorder(null);
		btnPesquisar.setBackground(new Color(0, 102, 52));
		btnPesquisar.setBounds(963, 36, 129, 34);
		panel_1.add(btnPesquisar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(TabelaClientes.class.getResource("/br/com/residencia/bankend/imagens/trash.png")));
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnLimpar.setDoubleBuffered(true);
		btnLimpar.setBorder(null);
		btnLimpar.setBackground(Color.RED);
		btnLimpar.setBounds(963, 36, 129, 34);
		panel_1.add(btnLimpar);

		btnLimpar.setVisible(false);

		
		Query bd = new Query(con);
		// Metodo responsavel por instanciar todos os clientes no Jtable
		bd.addAllClientes(paciente_tableModel);
	

		JLabel lblImagemPaciente = new JLabel("");
		lblImagemPaciente.setIcon(new ImageIcon(TabelaClientes.class.getResource("/br/com/residencia/bankend/imagens/1s.png")));
		lblImagemPaciente.setBounds(0, 553, 288, 172);
		panel.add(lblImagemPaciente);

		JLabel lblMenu = new JLabel("");
		lblMenu.setIcon(new ImageIcon(TabelaClientes.class.getResource("/br/com/residencia/bankend/imagens/2.jpg")));
		lblMenu.setBounds(6, 11, 232, 714);
		panel.add(lblMenu);

		// Instanciando meu proprio model (jtable)

		jTabelaPaciente.setModel(paciente_tableModel);
		
		// Escutadores + funçoes

		JLabel lblBackground = new JLabel("");
		lblBackground.setBackground(new Color(245, 245, 245));
		lblBackground.setIcon(new ImageIcon(TabelaClientes.class.getResource("/br/com/residencia/bankend/imagens/aaaaaaaaaaaaaaa.jpg")));
		lblBackground.setBounds(0, 0, 1129, 681);
		panel_1.add(lblBackground);

	}
}
