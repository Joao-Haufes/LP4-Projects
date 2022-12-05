package br.com.tlp4.visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import br.com.tlp4.visao.CursoGUI;

public class TelaPrincipal extends JFrame {
	
	private JMenuBar barraMenu;
	private JMenu menu;
	private JMenuItem menuItemCurso;
	private JMenuItem menuItemAluno;
	
	private EventoMenus eventoMenus ;
	
	
	
	private JMenuBar getBarraMenu() {
		if (barraMenu == null) {
			barraMenu = new JMenuBar();
			barraMenu.add(getMenu());
		}
		return barraMenu;
	}
	
	private JMenu getMenu() {
		if (menu == null) {
			menu = new JMenu("Gerenciar");
			menu.add(getMenuItemCurso());
			menu.add(getMenuItemAluno());
		}
		return menu;
	}
	
	private JMenuItem getMenuItemAluno() {
		if (menuItemAluno == null) {
			menuItemAluno = new JMenuItem("Alunos");
			menuItemAluno.addActionListener(getEventoMenus());			
		}
		return menuItemAluno;
	}
	
	private JMenuItem getMenuItemCurso() {
		if (menuItemCurso == null) {
			menuItemCurso = new JMenuItem("Cursos");
			menuItemCurso.addActionListener(getEventoMenus());	
		}
		return menuItemCurso;
	}
	
	
	private EventoMenus getEventoMenus() {
		if (eventoMenus == null) {
			eventoMenus = new EventoMenus(); 
		}
		return eventoMenus;
	}
	

	public TelaPrincipal() {
		super("Biblioteca");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(getBarraMenu()); //adiciona o menu
		this.setSize(800, 600);
		this.setLocationRelativeTo(null); // centraliza	a tela
		this.setVisible(true);		
	}
	
	// classe interna
	private class EventoMenus implements ActionListener{		
		public void actionPerformed(ActionEvent evento) {			
			if(evento.getSource() == getMenuItemCurso()){
				new CursoGUI();
			} else if (evento.getSource() == getMenuItemAluno()) {
				new AlunoGUI();
			} 
		}		
	}
	

}
