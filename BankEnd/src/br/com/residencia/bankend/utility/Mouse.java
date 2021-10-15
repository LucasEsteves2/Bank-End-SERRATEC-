package br.com.residencia.bankend.utility;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import br.com.residencia.bankend.visual.cliente.Menu;

public class Mouse extends MouseAdapter {

	private JPanel painel;
	

	public Mouse(JPanel painelConsulta) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	
		System.out.println("ta dentros");
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	
		System.out.println("Saiu");
	}
	
}
