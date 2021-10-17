package br.com.residencia.bankend.visual.funcionario;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.residencia.bankend.bd.Query;
import br.com.residencia.bankend.clientes.Cliente;
import br.com.residencia.bankend.contas.Contas;
import br.com.residencia.bankend.funcionarios.Funcionario;
import br.com.residencia.bankend.funcionarios.Gerente;

import javax.swing.JLabel;

public class Relatorioos extends JFrame {

	private JPanel contentPane;

	public Relatorioos(Funcionario fun, Connection con) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMesmaAgencia = new JLabel("Numero de contas com a mesma agencia");
		lblMesmaAgencia.setBounds(48, 58, 286, 14);
		contentPane.add(lblMesmaAgencia);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setVisible(false);
		lblNome.setBounds(48, 95, 196, 14);
		contentPane.add(lblNome);

		JLabel lblCpf = new JLabel("cpf");
		lblCpf.setVisible(false);
		lblCpf.setBounds(48, 133, 185, 14);
		contentPane.add(lblCpf);

		JLabel lblAgencia = new JLabel("agencia");
		lblAgencia.setVisible(false);
		lblAgencia.setBounds(48, 169, 152, 14);
		contentPane.add(lblAgencia);

		JLabel lblValorTotal = new JLabel("valorTotal");
		lblValorTotal.setVisible(false);
		lblValorTotal.setBounds(48, 206, 185, 14);
		contentPane.add(lblValorTotal);

		int acesso = fun.getAcesso();

		Query bd = new Query(con);

		ArrayList<Contas> conta = new ArrayList<>();
		
		

		switch (acesso) {
		case 1:
			Gerente gerente = (Gerente) fun;

			Integer quantidade = bd.qtdAgencia(gerente.getIdAgencia());
			lblMesmaAgencia.setText("a quantidade e :" + quantidade.toString());

			break;
		case 2:
			lblNome.setVisible(true);
			lblAgencia.setVisible(true);
			lblCpf.setVisible(true);
			System.out.println("DIRETOR");

			// metodo que envia uma lista e retorna todos os clientes e contas
			//metodo luqui
			bd.totalClientes(conta);
		
			for (Contas contas : conta) {

				System.out.println(contas.getCliente().getNome());
				System.out.println(contas.getCliente().getCpf());
				System.out.println(contas.getAgencia());

			}

			break;
		case 3:

			lblNome.setVisible(true);
			lblAgencia.setVisible(true);
			lblCpf.setVisible(true);
			lblValorTotal.setVisible(true);
			
			Double saldoTotal=bd.valorTotal();
			
			lblValorTotal.setText(saldoTotal.toString());
			
			
			System.out.println("PRESIDENTEEEEEEE");
			break;

		default:
			break;
		}

	}

}
