package br.com.residencia.bankend.visual.funcionario;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import br.com.residencia.bankend.bd.Query;
import br.com.residencia.bankend.contas.Contas;
import br.com.residencia.bankend.funcionarios.Diretor;
import br.com.residencia.bankend.funcionarios.Funcionario;
import br.com.residencia.bankend.funcionarios.Gerente;
import br.com.residencia.bankend.funcionarios.Presidente;

import java.sql.Connection;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.TextArea;

public class TelaRelatorio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Connection con;

	public TelaRelatorio(Funcionario fun, Connection con) {

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 546, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel CadastroCliente = new JLabel("Relatorios");
		CadastroCliente.setHorizontalAlignment(SwingConstants.CENTER);
		CadastroCliente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		CadastroCliente.setBounds(10, 11, 511, 31);
		contentPane.add(CadastroCliente);

		JLabel lblFoto = new JLabel("");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setIcon(new ImageIcon(TelaRelatorio.class.getResource("/br/com/residencia/bankend/imagens/12s.png")));
		lblFoto.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblFoto.setBounds(23, 67, 95, 114);
		contentPane.add(lblFoto);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(136, 90, 184, 17);
		contentPane.add(lblNome);

		JLabel lblCpf = new JLabel("E-mail");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(358, 90, 147, 17);
		contentPane.add(lblCpf);

		JLabel lblMesmaAgencia = new JLabel("Numero de contas com a mesma agencia: ");
		lblMesmaAgencia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMesmaAgencia.setBounds(151, 149, 290, 17);
		contentPane.add(lblMesmaAgencia);

		JPanel jpEmail = new JPanel();
		jpEmail.setBorder(new TitledBorder(null, "Endereço", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpEmail.setBounds(10, 195, 520, 187);
		contentPane.add(jpEmail);
		jpEmail.setLayout(null);

		TextArea textArea = new TextArea();
		textArea.setBounds(10, 26, 500, 151);
		jpEmail.add(textArea);
		textArea.setFont(new Font("Arial", Font.PLAIN, 12));
		textArea.setEditable(false);
		textArea.setBackground(Color.WHITE);

		int acesso = fun.getAcesso();

		Query bd = new Query(con);

		ArrayList<Contas> conta = new ArrayList<>();

		lblNome.setText("Nome: " + fun.getNome());
		lblCpf.setText("Cpf: " + fun.getCpf());

		JLabel lblValorTotal = new JLabel("VALOR TOTAL:");
		lblValorTotal.setVisible(false);
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblValorTotal.setForeground(Color.RED);
		lblValorTotal.setBounds(223, 53, 147, 14);
		contentPane.add(lblValorTotal);
		lblValorTotal.setVisible(false);

		
		// Verificando tipo do funcionario
		switch (acesso) {
		case 1:
			
			Gerente gerente = (Gerente) fun;

			Integer quantidade = bd.qtdAgencia(gerente.getIdAgencia());
			lblMesmaAgencia.setText("a quantidade e :" + quantidade.toString());

			break;
		case 2:
			
		
			System.out.println("Bem vindo Diretor ");

			// metodo que pega todas os nomes/cpf/agencia e armazena dentro de uma lista
			bd.totalClientes(conta);

			// metodo que adiciona no componente
			bd.addDadosRelatorios(textArea, conta);

			break;
		case 3:
			System.out.println("Bem vindo Presidente");

			bd.totalClientes(conta);
			bd.addDadosRelatorios(textArea, conta);

			Double saldoTotal = bd.valorTotal();
			
			lblValorTotal.setText(saldoTotal.toString());

			lblValorTotal.setVisible(true);
			break;

		default:
			break;
		}

	}
}
