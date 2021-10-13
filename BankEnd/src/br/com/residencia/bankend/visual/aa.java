package br.com.residencia.bankend.visual;

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

public class aa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String login;
	private String senha;
	private Connection con;
	private JTextField txtCartao;
	private JTextField textField_1;

	public aa(Connection con) {
		this.con = con;
		
		
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(aa.class.getResource("/br/com/residencia/imagens/cadeado-trancado.png")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_4_1 = new JButton("6");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_3_1_2 = new JButton("");
		btnNewButton_3_1_2.setIcon(new ImageIcon("C:\\Users\\Esteves\\Downloads\\atencao.png"));
		btnNewButton_3_1_2.setBackground(Color.YELLOW);
		btnNewButton_3_1_2.setBounds(1170, 534, 48, 22);
		contentPane.add(btnNewButton_3_1_2);
		
		JButton btnNewButton_3_1_2_1 = new JButton("");
		btnNewButton_3_1_2_1.setIcon(new ImageIcon("C:\\Users\\Esteves\\Downloads\\marca-de-verificacao (2).png"));
		btnNewButton_3_1_2_1.setBackground(new Color(50, 205, 50));
		btnNewButton_3_1_2_1.setBounds(1231, 534, 48, 22);
		contentPane.add(btnNewButton_3_1_2_1);
		btnNewButton_4_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4_1.setBounds(1231, 445, 48, 22);
		contentPane.add(btnNewButton_4_1);
		
		JButton btnNewButton_4_1_1 = new JButton("0");
		btnNewButton_4_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4_1_1.setBounds(1170, 505, 48, 22);
		contentPane.add(btnNewButton_4_1_1);
		
		JButton btnNewButton_3_1_1 = new JButton("#");
		btnNewButton_3_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3_1_1.setBounds(1231, 505, 48, 22);
		contentPane.add(btnNewButton_3_1_1);
		
		JButton btnNewButton_6 = new JButton("*");
		btnNewButton_6.setBackground(Color.LIGHT_GRAY);
		btnNewButton_6.setBounds(1111, 505, 48, 22);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_3_1 = new JButton("");
		btnNewButton_3_1.setIcon(new ImageIcon("C:\\Users\\Esteves\\Downloads\\cancelar.png"));
		btnNewButton_3_1.setBackground(new Color(220, 20, 60));
		btnNewButton_3_1.setBounds(1111, 534, 50, 22);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(1111, 416, 48, 22);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_5 = new JButton("8");
		btnNewButton_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton_5.setBounds(1170, 476, 48, 22);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_1_1 = new JButton("9");
		btnNewButton_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_1.setBounds(1231, 476, 48, 22);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("7");
		btnNewButton_2_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2_1.setBounds(1111, 475, 48, 22);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_1 = new JButton("2");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(1170, 416, 48, 22);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("3");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setBounds(1231, 416, 48, 22);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("4");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.setBounds(1110, 445, 48, 22);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("5");
		btnNewButton_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4.setBounds(1170, 445, 48, 22);
		contentPane.add(btnNewButton_4);

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

		btnVerificar.setBounds(818, 381, 97, 23);
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
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\oriignal2.png"));
		lblNewLabel_3.setBounds(921, -538, 1026, 1913);
		contentPane.add(lblNewLabel_3);

		JLabel lblCartao = new JLabel("Contaa:");
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
