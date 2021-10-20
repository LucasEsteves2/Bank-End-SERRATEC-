package br.com.residencia.bankend.visual.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.residencia.bankend.bd.Query;
import br.com.residencia.bankend.contas.Contas;
import br.com.residencia.bankend.contas.SeguroVida;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.SwingConstants;

public class TelaSeguroVida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtValor;

	public TelaSeguroVida(Contas conta, Connection con) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSeguroVida.class.getResource("/br/com/residencia/bankend/imagens/plano-de-saude.png")));
		setTitle("Seguro de vida");
		setResizable(false);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(-3, -18, 499, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSeguro1 = new JLabel("Informe o valor do seguro desejado");
		lblSeguro1.setVisible(false);
		lblSeguro1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSeguro1.setBounds(22, 13, 240, 20);
		contentPane.add(lblSeguro1);

		txtValor = new JTextField();
		txtValor.setVisible(false);
		txtValor.setColumns(10);
		txtValor.setBounds(264, 11, 86, 24);
		contentPane.add(txtValor);

		JButton btnVerifica = new JButton("contratar");
		btnVerifica.setVisible(false);
		btnVerifica.setBounds(359, 11, 97, 23);
		contentPane.add(btnVerifica);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(-14, 40, 519, 8);
		contentPane.add(scrollPane);

		JPanel pnlcorprincip = new JPanel();
		pnlcorprincip.setBackground(new Color(0, 255, 127));
		pnlcorprincip.setBounds(0, 0, 505, 40);
		contentPane.add(pnlcorprincip);
		pnlcorprincip.setLayout(null);

		JLabel lblStatus = new JLabel("Status: Ativo");
		lblStatus.setVisible(false);
		lblStatus.setForeground(new Color(255, 255, 255));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblStatus.setBounds(0, 0, 495, 40);
		pnlcorprincip.add(lblStatus);

		JPanel pnlCor = new JPanel();
		pnlCor.setBackground(new Color(0, 255, 255));
		pnlCor.setBounds(-1, -1, 506, 44);
		contentPane.add(pnlCor);
		pnlCor.setLayout(null);
		JLabel background = new JLabel("\r\n");
		background.setIcon(new ImageIcon(TelaSeguroVida.class.getResource("/br/com/residencia/bankend/imagens/seguri.jpg")));
		background.setBounds(-3, 44, 496, 370);
		contentPane.add(background);
		pnlCor.setVisible(false);

		if (conta.getSeguro() == null) {
			lblSeguro1.setVisible(true);
			txtValor.setVisible(true);
			btnVerifica.setVisible(true);

		} else {

			lblStatus.setVisible(true);
		}

		// add verifica se o vlaor informado possui na conta

		Query bd = new Query(con);

		btnVerifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Double valor = Double.parseDouble(txtValor.getText());

				if (conta.getSaldo() > valor) {

					SeguroVida seguro = new SeguroVida(valor);

					seguro.calculo(valor);

					if (conta.getSaldo() > valor + seguro.getTaxa()) {

						conta.setSeguro(seguro);

						bd.instanciaSeguro(conta);

						JOptionPane.showMessageDialog(null, "Seguro Contratado!!", "ERROR(404)",
								JOptionPane.INFORMATION_MESSAGE);
						lblSeguro1.setVisible(false);
						txtValor.setVisible(false);
						btnVerifica.setVisible(false);

					}
				} else {
					System.out.println("valor invalido");
				}

			}
		});

	}

}
