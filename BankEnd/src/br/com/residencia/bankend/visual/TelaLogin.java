package br.com.residencia.bankend.visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.com.residencia.bankend.bd.Query;
import br.com.residencia.bankend.clientes.Cliente;
import br.com.residencia.bankend.contas.Contas;
import br.com.residencia.bankend.funcionarios.Funcionario;
import br.com.residencia.bankend.visual.cliente.Menu;
import br.com.residencia.bankend.visual.funcionario.MenuFuncionario;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JPasswordField txtSenha;
	private String login;
	private String senha;
	private Connection con;
	private Contas conta;

//polvo laser
	public TelaLogin(Connection con) {
		this.con = con;

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TelaLogin.class.getResource("/br/com/residencia/bankend/imagens/cadeado-trancado.png")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtSenha = new JPasswordField();
		txtSenha.setToolTipText("Informe a senha");
		txtSenha.setBounds(924, 378, 341, 36);
		contentPane.add(txtSenha);

		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.setInheritsPopupMenu(true);
		btnAcessar.setMargin(new Insets(2, 7, 2, 14));
		btnAcessar.setHorizontalAlignment(SwingConstants.LEFT);
		btnAcessar.setIconTextGap(10);
		btnAcessar.setIcon(new ImageIcon(
				TelaLogin.class.getResource("/br/com/residencia/bankend/imagens/cadeado-aberto (4).png")));
		btnAcessar.setBounds(1145, 434, 121, 44);
		contentPane.add(btnAcessar);

		JLabel imgCadeado = new JLabel("");
		imgCadeado.setIcon(
				new ImageIcon(TelaLogin.class.getResource("/br/com/residencia/bankend/imagens/cadeado-trancado.png")));
		imgCadeado.setForeground(new Color(0, 255, 0));
		imgCadeado.setBounds(1061, 157, 87, 105);
		imgCadeado.setFont(new Font("Tahoma", Font.BOLD, 29));
		contentPane.add(imgCadeado);

		JLabel lblSenha = new JLabel("Sua Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSenha.setBounds(926, 357, 168, 14);
		contentPane.add(lblSenha);

		JLabel lblNome = new JLabel("Seu Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(926, 266, 169, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setToolTipText("Informe o nome do administrador");
		txtNome.setBounds(924, 287, 341, 36);
		txtNome.setColumns(10);
		contentPane.add(txtNome);

		String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		JLabel lblCadastrarNovo = new JLabel(timeStamp);
		lblCadastrarNovo.setIcon(new ImageIcon(TelaLogin.class.getResource("/br/com/residencia/bankend/imagens/data-limite.png")));

		lblCadastrarNovo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCadastrarNovo.setBounds(899, 507, 156, 32);
		lblCadastrarNovo.setForeground(new Color(255, 255, 255));
		contentPane.add(lblCadastrarNovo);

		JLabel lblfundoTransparente = new JLabel("");
		lblfundoTransparente.setBounds(883, 157, 416, 390);
		lblfundoTransparente.setIcon(
				new ImageIcon(TelaLogin.class.getResource("/br/com/residencia/bankend/imagens/FUNDO PRA TELA.png")));
		contentPane.add(lblfundoTransparente);

		JLabel ImgBackground = new JLabel("");
		ImgBackground.setBounds(0, 0, 1375, 705);
		ImgBackground.setIcon(new ImageIcon(TelaLogin.class.getResource("/br/com/residencia/bankend/imagens/login2.jpg")));
		contentPane.add(ImgBackground);

		Query bd = new Query(con);
		btnAcessar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				login = txtNome.getText();
				senha = String.valueOf(txtSenha.getPassword());
				Cliente cliente = null;
				Funcionario funcionario = null;
				// pega dados de funcionario
				funcionario = bd.dadosFuncionario(login, senha);
				// pega dados de cliente
				cliente = bd.cliente(login, senha);

				// instancia Tela funcionario
				if (funcionario != null || cliente != null) {

					// verificando se funcionario possui uma conta
					if (bd.contaFuncionario(login, senha)) {
						System.out.println("possui conta");

						int i = JOptionPane.showConfirmDialog(null, "Entrar em admin", "??",
								JOptionPane.OK_CANCEL_OPTION);

						// se clicar em sim
						if (i == JOptionPane.YES_OPTION) {

							System.out.println("Clicou em Sim");
							System.out.println("Entrando na conta como funcionario");
							telaFuncionario(funcionario);

						}
						// se clicar em nao

						else if (i == JOptionPane.CANCEL_OPTION) {

							System.out.println("Clicou em Não");
							System.out.println("Entrando na conta como cliente");
							conta = bd.descobreConta(cliente);
							telaCliente();
						}

					} else {
						System.out.println("Funcionario nao possui conta");

						if (funcionario != null) {

							telaFuncionario(funcionario);

						}

						// instancia Tela cliente
						if (cliente != null) {
							// metodo que retorna a conta do cliente
							conta = bd.descobreConta(cliente);
							telaCliente();
						}

					}

				}

				// instancia Tela cliente

				if (cliente == null && funcionario == null) {

					txtNome.setBorder(new LineBorder(Color.RED));
					txtSenha.setBorder(new LineBorder(Color.RED));

					JOptionPane.showMessageDialog(null, "CONTA INVALIDA!!", "#ERRO404", JOptionPane.ERROR_MESSAGE);

				}

			}

		});

	}

	public void telaFuncionario(Funcionario funcionario) {

		txtNome.setBorder(new LineBorder(Color.GREEN));
		txtSenha.setBorder(new LineBorder(Color.green));
		JOptionPane.showMessageDialog(null, "Bem Vindo," + funcionario.getNome() + "!!", "Sucess",
				JOptionPane.INFORMATION_MESSAGE);

		MenuFuncionario menu = new MenuFuncionario(con, funcionario);
		menu.setVisible(true);
		dispose();

	}

	public void telaCliente() {

		// Troca a cor do txt para verde
		txtNome.setBorder(new LineBorder(Color.GREEN));
		txtSenha.setBorder(new LineBorder(Color.green));
		// mensagem de bem vindo
		JOptionPane.showMessageDialog(null, "Bem Vindo," + conta.getCliente().getNome() + "!!", "Sucess",
				JOptionPane.INFORMATION_MESSAGE);

		// instancia da janela
		Menu menu = new Menu(con, conta);
		menu.setVisible(true);
		dispose();

	}

}
