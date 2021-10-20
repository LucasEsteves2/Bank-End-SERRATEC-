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
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import br.com.residencia.bankend.bd.Query;
import br.com.residencia.bankend.contas.Contas;
import br.com.residencia.bankend.funcionarios.Funcionario;
import br.com.residencia.bankend.utility.ClienteTableModel;
import br.com.residencia.bankend.visual.TelaLogin;

public class TabelaClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jTabelaPaciente;
	private JTextField txtPesquisar;
	@SuppressWarnings("unused")
	private ArrayList<Contas> pacientes = new ArrayList<>();
	ClienteTableModel paciente_tableModel = new ClienteTableModel();

	public TabelaClientes(Connection con,Funcionario fun) {
		setTitle("Bank End");

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Esteves\\Desktop\\banco.png"));
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

		JLabel lblNewLabel_4 = new JLabel(">Clientes");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBounds(71, 10, 61, 14);
		PainelVoltar.add(lblNewLabel_4);

		JPanel PainelFechar = new JPanel();
		PainelFechar.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		PainelFechar.setLayout(null);
		PainelFechar.setBackground(Color.WHITE);
		PainelFechar.setBounds(-1, 252, 246, 56);
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

		JPanel painelRelatorios = new JPanel();
		painelRelatorios.setBorder(new MatteBorder(2, 1, 1, 1, (Color) new Color(0, 0, 0)));
		painelRelatorios.setLayout(null);
		painelRelatorios.setBackground(Color.WHITE);
		painelRelatorios.setBounds(-1, 140, 246, 56);
		panel.add(painelRelatorios);

		JLabel imgPaciente_1_1 = new JLabel("");
		imgPaciente_1_1.setIcon(new ImageIcon(TabelaClientes.class.getResource("/br/com/residencia/bankend/imagens/relatorio.png")));
		imgPaciente_1_1.setBounds(23, 12, 32, 32);
		painelRelatorios.add(imgPaciente_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setBackground(Color.GREEN);
		lblNewLabel_2_1_1.setBounds(79, 16, 0, 0);
		painelRelatorios.add(lblNewLabel_2_1_1);

		JLabel txtMedico_1_1 = new JLabel("Relatorios");
		txtMedico_1_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtMedico_1_1.setBounds(68, 16, 115, 22);
		painelRelatorios.add(txtMedico_1_1);

		JPanel painelClientes = new JPanel();
		painelClientes.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		painelClientes.setLayout(null);
		painelClientes.setBackground(new Color(240, 248, 255));
		painelClientes.setBounds(-1, 196, 245, 56);
		panel.add(painelClientes);

		JLabel imgPaciente_1 = new JLabel("");
		imgPaciente_1.setIcon(new ImageIcon(TabelaClientes.class.getResource("/br/com/residencia/bankend/imagens/cliente.png")));
		imgPaciente_1.setBounds(23, 12, 32, 32);
		painelClientes.add(imgPaciente_1);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBackground(Color.GREEN);
		lblNewLabel_2_1.setBounds(79, 16, 0, 0);
		painelClientes.add(lblNewLabel_2_1);

		JLabel txtMedico_1 = new JLabel("Clientes");
		txtMedico_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtMedico_1.setBounds(68, 16, 90, 22);
		painelClientes.add(txtMedico_1);
		
		JLabel painelRelatorios_1 = new JLabel("");
		painelRelatorios_1.setBounds(1, -3, 244, 143);
		panel.add(painelRelatorios_1);
		
		JLabel painelRelatorios_2 = new JLabel("");
		painelRelatorios_2.setHorizontalAlignment(SwingConstants.CENTER);
		painelRelatorios_2.setHorizontalTextPosition(SwingConstants.CENTER);
		painelRelatorios_2.setIcon(new ImageIcon(TabelaClientes.class.getResource("/br/com/residencia/bankend/imagens/logo.png")));
		painelRelatorios_2.setBounds(-1, 11, 244, 130);
		panel.add(painelRelatorios_2);

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
		btnExcluir.setEnabled(false);
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
		btnEditar.setEnabled(false);
		
		btnEditar.setIcon(new ImageIcon(TabelaClientes.class.getResource("/br/com/residencia/bankend/imagens/edit.png")));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnEditar.setDoubleBuffered(true);
		btnEditar.setBorder(null);
		btnEditar.setBackground(new Color(0, 102, 52));
		btnEditar.setBounds(144, 36, 90, 35);
		panel_1.add(btnEditar);

		JButton btnNovo = new JButton("Novo");
		btnNovo.setEnabled(false);
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

		// Instanciando meu proprio model (jtable)

		jTabelaPaciente.setModel(paciente_tableModel);
		
		// Escutadores + funçoes

		JLabel lblBackground = new JLabel("");
		lblBackground.setBackground(new Color(245, 245, 245));
		lblBackground.setBounds(0, 0, 1129, 681);
		panel_1.add(lblBackground);

		
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

			
		
		painelClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TabelaClientes clientes = new TabelaClientes(con,fun);
				clientes.setLocationRelativeTo(null);
				clientes.setVisible(true);
				
				
			}
		});

		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MenuFuncionario telaFuncionario = new MenuFuncionario(con,fun);
				telaFuncionario.setVisible(true);
				dispose();
				
			}
		});
		
		painelRelatorios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaRelatorios relatorio = new TelaRelatorios(con, fun);
				relatorio.setLocationRelativeTo(null);
				relatorio.setVisible(true);
			}
		});
	}
}
