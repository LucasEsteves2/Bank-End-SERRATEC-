package br.com.residencia.bankend.utility;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailApp {

	public void enviarEmail(String mensagem, String assunto, String email) {
		Properties props = new Properties();
		
		/** Parametros de conex„o com o servidor email */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("mentaanivia@gmail.com", "senha");
			}
		});

		/** Ativa o debug para a sessao */
		session.setDebug(true);

		//TENTA ENVIAR O EMAIL CASO CONTRARIO EXTORA A EXCEPTION
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente

			Address[] toUser = InternetAddress // Destinat√°rio(s)
					.parse(email);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(assunto);// Assunto
			message.setText(mensagem);
			/** Metodo da api  para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			System.out.println("FALHA AO ENVIAR O E-MAIL");
			throw new RuntimeException(e);
		}

	}

}
