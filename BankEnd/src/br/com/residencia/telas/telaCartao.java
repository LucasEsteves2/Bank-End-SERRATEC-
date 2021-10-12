package br.com.residencia.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.border.MatteBorder;
import java.awt.ComponentOrientation;
import java.awt.Panel;
import java.awt.Label;

public class telaCartao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String login;
	private String senha;
	private Connection con;
	private JTextField txtCartao;
	private JTextField textField_1;

	public telaCartao(Connection con) {
		this.con = con;
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(telaCartao.class.getResource("/br/com/residencia/imagens/cadeado-trancado.png")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCartao_1 = new JLabel("LUCAS ESTEVES DE ABREU");
		lblCartao_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCartao_1.setForeground(Color.WHITE);
		lblCartao_1.setBackground(Color.WHITE);
		lblCartao_1.setBounds(736, 424, 158, 14);
		contentPane.add(lblCartao_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Esteves\\Downloads\\A23.png"));
		lblNewLabel_1.setBounds(701, 412, 214, 43);
		contentPane.add(lblNewLabel_1);

		JButton btnVerificar = new JButton("VERIFICAR");
		btnVerificar.setBounds(826, 381, 89, 23);
		contentPane.add(btnVerificar);

		JLabel lblNewLabel_6 = new JLabel("INFORME UM VALOR");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(1140, 284, 113, 15);
		contentPane.add(lblNewLabel_6);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(1145, 309, 97, 20);
		contentPane.add(textField_1);

		JLabel lblNewLabel_4 = new JLabel("Cliente: Lucas Esteves");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(1117, 165, 151, 17);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\original.png"));
		lblNewLabel_3.setBounds(921, -538, 1026, 1913);
		contentPane.add(lblNewLabel_3);

		JLabel lblCartao = new JLabel("Conta:");
		lblCartao.setForeground(Color.WHITE);
		lblCartao.setBackground(Color.WHITE);
		lblCartao.setBounds(797, 331, 158, 14);
		contentPane.add(lblCartao);

		txtCartao = new JTextField();
		txtCartao.setColumns(10);
		txtCartao.setBounds(795, 348, 160, 20);
		contentPane.add(txtCartao);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\card222323.png"));
		lblNewLabel.setBounds(512, 143, 638, 365);
		contentPane.add(lblNewLabel);

		String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());

		JLabel ImgBackground = new JLabel("");
		ImgBackground.setBounds(0, 0, 1375, 705);
		ImgBackground.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\2133232232323.jpg"));
		contentPane.add(ImgBackground);

	}
}
