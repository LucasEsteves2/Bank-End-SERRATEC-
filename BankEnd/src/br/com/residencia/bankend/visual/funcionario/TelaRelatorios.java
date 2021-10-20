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
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import br.com.residencia.bankend.bd.Query;
import br.com.residencia.bankend.contas.Contas;
import br.com.residencia.bankend.funcionarios.Funcionario;
import br.com.residencia.bankend.funcionarios.Gerente;
import br.com.residencia.bankend.utility.FuncionarioTableModel;
import br.com.residencia.bankend.visual.TelaLogin;

import javax.swing.border.EtchedBorder;

public class TelaRelatorios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jTabelaPaciente;
	@SuppressWarnings("unused")
	private ArrayList<Contas> relatorios = new ArrayList<>();
	FuncionarioTableModel funcionario_tableModel = new FuncionarioTableModel();

	public TelaRelatorios(Connection con, Funcionario fun) {
		setTitle("Relatorios");

		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaRelatorios.class.getResource("/br/com/residencia/bankend/imagens/banco.png")));
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

		JLabel painelRelatorios = new JLabel("");
		painelRelatorios.setHorizontalAlignment(SwingConstants.CENTER);
		painelRelatorios.setIcon(new ImageIcon(TelaRelatorios.class.getResource("/br/com/residencia/bankend/imagens/logo.png")));
		painelRelatorios.setBounds(-1, 11, 244, 132);
		panel.add(painelRelatorios);

		Panel PainelVoltar = new Panel();
		PainelVoltar.setBackground(new Color(248, 248, 255));
		PainelVoltar.setBounds(235, 0, 1139, 26);
		contentPane.add(PainelVoltar);
		PainelVoltar.setLayout(null);

		JLabel lblInicio = new JLabel("");

		lblInicio.setIcon(new ImageIcon(
				TelaRelatorios.class.getResource("/br/com/residencia/bankend/imagens/pagina-inicial (1).png")));
		lblInicio.setBounds(10, -1, 29, 30);
		PainelVoltar.add(lblInicio);

		JLabel lblNewLabel_5 = new JLabel("Home");
		lblNewLabel_5.setForeground(new Color(192, 192, 192));
		lblNewLabel_5.setBackground(new Color(0, 0, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(37, 10, 46, 14);
		PainelVoltar.add(lblNewLabel_5);

		JLabel lblNewLabel_4 = new JLabel("> Relatorios");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBounds(71, 10, 70, 14);
		PainelVoltar.add(lblNewLabel_4);

		JPanel PainelFechar = new JPanel();
		PainelFechar.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		PainelFechar.setLayout(null);
		PainelFechar.setBackground(Color.WHITE);
		PainelFechar.setBounds(-1, 252, 246, 56);
		panel.add(PainelFechar);

		JLabel imgPaciente_1_1_1 = new JLabel("");
		imgPaciente_1_1_1.setIcon(
				new ImageIcon(TelaRelatorios.class.getResource("/br/com/residencia/bankend/imagens/cancelar.png")));
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
		PainelConsulta.setBackground(new Color(240, 248, 255));
		PainelConsulta.setBounds(-1, 140, 246, 56);
		panel.add(PainelConsulta);

		JLabel imgPaciente_1_1 = new JLabel("");
		imgPaciente_1_1.setIcon(
				new ImageIcon(TelaRelatorios.class.getResource("/br/com/residencia/bankend/imagens/relatorio.png")));
		imgPaciente_1_1.setBounds(23, 12, 32, 32);
		PainelConsulta.add(imgPaciente_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setBackground(Color.GREEN);
		lblNewLabel_2_1_1.setBounds(79, 16, 0, 0);
		PainelConsulta.add(lblNewLabel_2_1_1);

		JLabel txtRelatorio = new JLabel("Relatorios");
		txtRelatorio.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtRelatorio.setBounds(68, 16, 115, 22);
		PainelConsulta.add(txtRelatorio);

		JPanel painelClientes = new JPanel();
		painelClientes.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		painelClientes.setLayout(null);
		painelClientes.setBackground(Color.WHITE);
		painelClientes.setBounds(-1, 196, 245, 56);
		panel.add(painelClientes);

		JLabel imgPaciente_1 = new JLabel("");
		imgPaciente_1.setIcon(
				new ImageIcon(TelaRelatorios.class.getResource("/br/com/residencia/bankend/imagens/cliente.png")));
		imgPaciente_1.setBounds(23, 12, 32, 32);
		painelClientes.add(imgPaciente_1);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBackground(Color.GREEN);
		lblNewLabel_2_1.setBounds(79, 16, 0, 0);
		painelClientes.add(lblNewLabel_2_1);

		JLabel txtClientes = new JLabel("Clientes");
		txtClientes.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtClientes.setBounds(68, 16, 90, 22);
		painelClientes.add(txtClientes);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(235, 30, 1139, 692);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 151, 1070, 480);
		panel_1.add(scrollPane);

		jTabelaPaciente = new JTable();

		scrollPane.setViewportView(jTabelaPaciente);

		Query bd = new Query(con);

		// Instanciando meu proprio model (jtable)

		jTabelaPaciente.setModel(funcionario_tableModel);

		JLabel lblFoto = new JLabel("");
		lblFoto.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFoto.setIcon(new ImageIcon(TelaRelatorios.class.getResource("/br/com/residencia/bankend/imagens/12s.png")));
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblFoto.setBounds(28, 24, 95, 101);
		panel_1.add(lblFoto);

		JLabel lblFotoCargo = new JLabel("GERENTE");
		lblFotoCargo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoCargo.setBounds(27, 31, 96, 14);
		panel_1.add(lblFotoCargo);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(150, 31, 190, 20);
		panel_1.add(lblNome);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCpf.setBounds(406, 31, 129, 20);
		panel_1.add(lblCpf);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(687, 31, 220, 20);
		panel_1.add(lblEmail);

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCargo.setBounds(955, 31, 157, 20);
		panel_1.add(lblCargo);

		JLabel lblBackground = new JLabel("");
		lblBackground.setBackground(new Color(245, 245, 245));
		lblBackground.setBounds(0, 0, 0, 0);
		panel_1.add(lblBackground);

		JLabel lblValorTotal = new JLabel("VALOR TOTAL:");
		lblValorTotal.setVisible(false);
		lblValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorTotal.setForeground(Color.RED);
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblValorTotal.setBounds(26, 81, 1070, 44);
		panel_1.add(lblValorTotal);

		JLabel lblMesmaAgencia = new JLabel("");
		lblMesmaAgencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesmaAgencia.setForeground(Color.RED);
		lblMesmaAgencia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMesmaAgencia.setVisible(false);
		lblMesmaAgencia.setBounds(-1, 91, 1129, 23);
		panel_1.add(lblMesmaAgencia);

		lblNome.setText("Nome: " + fun.getNome());
		lblCpf.setText("Cpf: " + fun.getCpf());
		
		lblEmail.setText("E-mail:" + fun.getEmail());

		int acesso = fun.getAcesso();
		ArrayList<Contas> conta = new ArrayList<>();

		// Verificando tipo do funcionario
		switch (acesso) {
		case 1:
			System.out.println("Bem vindo GERENTE ");

			lblMesmaAgencia.setVisible(true);

			Gerente gerente = (Gerente) fun;

			Integer quantidade = bd.qtdAgencia(gerente.getIdAgencia());
			lblMesmaAgencia.setText("A quantidade de Contas que voce gerencia é de:" + quantidade.toString());
			lblFotoCargo.setText("GERENTE");

			lblCargo.setText("Cargo:GERENTE" );
			break;
		case 2:

			System.out.println("Bem vindo Diretor ");

			// metodo que pega todas os nomes/cpf/agencia e armazena dentro de uma lista
			bd.trazerRelatorio(conta,fun);
			// metodo que adiciona no componente
			bd.addDadosRelatorios(funcionario_tableModel, conta);
			lblFotoCargo.setText("DIRETOR");
			lblCargo.setText("Cargo:DIRETOR" );
			break;

		case 3:
			System.out.println("Bem vindo Presidente");
			lblValorTotal.setVisible(true);
			// retorna todas as cotnas na minha lista
			bd.trazerRelatorio(conta,fun);

			// Metodo responsavel por instanciar todos os clientes no Jtable
			bd.addDadosRelatorios(funcionario_tableModel, conta);

			Double saldoTotal = bd.valorTotal();

			lblValorTotal.setText("VALOR TOTAL: " + saldoTotal.toString() + "$");

			lblValorTotal.setVisible(true);
			lblFotoCargo.setText("PRESIDENTE");
			lblCargo.setText("Cargo:PRESIDENTE" );
			break;

		default:
			break;
		}

		painelClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				TabelaClientes clientes = new TabelaClientes(con, fun);
				clientes.setLocationRelativeTo(null);
				clientes.setVisible(true);

			}
		});

		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				MenuFuncionario telaFuncionario = new MenuFuncionario(con, fun);
				telaFuncionario.setVisible(true);
				dispose();

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

	
}
