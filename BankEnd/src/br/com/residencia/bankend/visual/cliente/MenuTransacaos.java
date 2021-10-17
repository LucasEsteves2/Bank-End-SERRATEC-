package br.com.residencia.bankend.visual.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.residencia.bankend.bd.Query;
import br.com.residencia.bankend.contas.ContaCorrente;
import br.com.residencia.bankend.contas.ContaPoupanca;
import br.com.residencia.bankend.contas.Contas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuTransacaos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String login;
	private String senha;
	private Connection con;
	private Contas contaDestinatario = null;
	private Contas contaRemetente = null;
	ContaCorrente corrente = null;
	private ContaPoupanca poupanca = null;

	public MenuTransacaos(Connection conexao, Contas contaRemetente) {
		this.con = conexao;
		this.contaRemetente = contaRemetente;

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MenuTransacaos.class.getResource("/br/com/residencia/bankend/imagens/cadeado-trancado.png")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		
		lblNewLabel.setBounds(994, 56, 368, 610);
		contentPane.add(lblNewLabel);
		
		JLabel lblSaque = new JLabel("");
		
		lblSaque.setBounds(513, 56, 354, 610);
		contentPane.add(lblSaque);
		
		JLabel lblTransferencia = new JLabel("");
		
		lblTransferencia.setBounds(26, 56, 354, 610);
		contentPane.add(lblTransferencia);
		
		JLabel ImgBackground = new JLabel("");
		ImgBackground.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\BANKEND\\backzada.jpg"));
		ImgBackground.setBounds(0, 0, 1375, 705);
		contentPane.add(ImgBackground);


		
		lblTransferencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("FUI CLICADO");
				
				Transferencia transferencia = new Transferencia(conexao, contaRemetente);
				transferencia.setVisible(true);
				dispose();
				
			}
		});
		
		
		
		lblSaque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				System.out.println("FUI CLICADO");
				Saque telaSaque = new Saque(conexao, contaRemetente);
				telaSaque.setVisible(true);
				
				
			}
		});
		
		
		
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Deposito telaDeposito = new Deposito(conexao, contaRemetente);
				telaDeposito.setVisible(true);
				dispose();
			}
		});
		
	}
}
