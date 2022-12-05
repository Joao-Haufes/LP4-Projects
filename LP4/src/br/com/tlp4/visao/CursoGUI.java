package br.com.tlp4.visao;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import br.com.tlp4.controle.CursoControle;
import br.com.tlp4.modelo.Curso;


public class CursoGUI extends JDialog{ //MVC
	
	private JPanel painel;
	
	private JLabel labelId;
	private JTextField textId;
	
	private JLabel labelNome;
	private JTextField textNome;
	
	private JLabel labelVaga;
	private JTextField textVaga;
	
	private JButton botaoSalvar;
	private JButton botaoAlterar;
	private JButton botaoRemover;
	private JButton botaoLimpar;
	
	
	private EventoBotoes eventoBotoes ;
	private EventoBotoes getEventoBotoes() {
		if (eventoBotoes ==  null) {
			eventoBotoes = new EventoBotoes();
		}		
		return eventoBotoes;
	}

	public CursoGUI() {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("Gerenciar Cursos");
		this.setModal(true); // bloqueia a janela principal
		this.setSize(570, 410);
		this.setLocationRelativeTo(null); // centraliza	a tela	
		this.setContentPane(getPainel()); //adiciona painel
		atualizarTabela(); // buscas os cursos no banco para mostrar na tabela
		this.setVisible(true);
	}
	
	private JPanel getPainel() {
		if (painel == null) {
			painel = new JPanel();
			painel.setLayout(null);
			painel.add(getLabelId());
			painel.add(getTextId());
			
			painel.add(getLabelNome());
			painel.add(getTextNome());
			
			painel.add(getLabelVaga());
			painel.add(getTextVaga());	
			
			//adiciona os botões na tela
			painel.add(getBotaoSalvar());
			painel.add(getBotaoAlterar());
			painel.add(getBotaoRemover());
			painel.add(getBotaoLimpar());
			
			painel.add(getBarraRolagem()); // tabela
		}
		return painel;
	}
	
	private JLabel getLabelId() {
		
		if (labelId == null) {
			labelId = new JLabel("Id: ");
			labelId.setBounds(10, 10, 30, 25);
		}
		return labelId;
	}

	private JTextField getTextId() {		
		
		if (textId == null) {
			textId = new JTextField();
			textId.setEnabled(false);
			textId.setBounds(100, 10, 30, 25);
		}
		return textId;
	}

	
	private JLabel getLabelNome() {
		
		if (labelNome == null) {
			labelNome = new JLabel("Nome: ");
			labelNome.setBounds(10, 40, 50, 25);
		}
		return labelNome;
	}

	private JTextField getTextNome() {		
		
		if (textNome == null) {
			textNome = new JTextField();
			textNome.setBounds(100, 40, 300, 25);
		}
		return textNome;
	}
	
	private JLabel getLabelVaga() {
		
		if (labelVaga == null) {
			labelVaga = new JLabel("Vagas: ");
			labelVaga.setBounds(10, 70, 80, 25);
		}
		return labelVaga;
	}

	private JTextField getTextVaga() {		
		
		if (textVaga == null) {
			textVaga = new JTextField();
			textVaga.setBounds(100, 70, 80, 25);
		}
		return textVaga;
	}	
	
	
	private JButton getBotaoSalvar() {
		if(botaoSalvar == null){
			botaoSalvar = new JButton("Salvar");
			botaoSalvar.setToolTipText("clique aqui para salvar");
			botaoSalvar.setBounds(30, 120, 100, 25);
			botaoSalvar.addActionListener(getEventoBotoes());
		}
		return botaoSalvar;
	}

	private JButton getBotaoAlterar() {
		if(botaoAlterar == null){
			botaoAlterar = new JButton("Alterar");
			botaoAlterar.setToolTipText("clique aqui para alterar");
			botaoAlterar.setBounds(150, 120, 100, 25);
			botaoAlterar.addActionListener(getEventoBotoes());
		}
		return botaoAlterar;
	}
	
	private JButton getBotaoRemover() {
		if(botaoRemover == null){
			botaoRemover = new JButton("Remover");
			botaoRemover.setToolTipText("clique aqui para remover");
			botaoRemover.setBounds(270, 120, 100, 25);
			botaoRemover.addActionListener(getEventoBotoes());
		}
		return botaoRemover;
	}
	
	private JButton getBotaoLimpar() {
		if(botaoLimpar == null){
			botaoLimpar = new JButton("Limpar");
			botaoLimpar.setToolTipText("clique aqui para limpar");
			botaoLimpar.setBounds(390, 120, 100, 25);
			botaoLimpar.addActionListener(getEventoBotoes());
		}
		return botaoLimpar;
	}
	
	private class EventoBotoes implements ActionListener{		
		public void actionPerformed(ActionEvent evento) {			
			if(evento.getSource() == getBotaoSalvar()){
				//System.out.println("Clicou em salvar");
				salvar();
			} else if (evento.getSource() == getBotaoAlterar()) {
				//System.out.println("Clicou em alterar");
				alterar();
			} else if (evento.getSource() == getBotaoRemover()) {
				//System.out.println("Clicou em remover");
				remover();
			} else if (evento.getSource() == getBotaoLimpar()) {
				limparCampos();
			}
		}		
	}	
	private void limparCampos() {
		getTextId().setText("");
		getTextNome().setText("");
		getTextVaga().setText("");
	}
	
	// métodos de acesso a camada controle
	private void salvar() {
		String nome = getTextNome().getText();
		int quantVagas = Integer.parseInt(getTextVaga().getText());
		CursoControle controle = new CursoControle();
		try {
			controle.salvarCurso(nome, quantVagas);			
			JOptionPane.showMessageDialog(null, "Sucesso ao salvar", "Sucesso", 
					JOptionPane.INFORMATION_MESSAGE);
			atualizarTabela();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar", "Erro", 
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	private void alterar() {
		String nome = getTextNome().getText();
		int quantVagas = Integer.parseInt(getTextVaga().getText());
		long id = Long.parseLong(getTextId().getText());
		CursoControle controle = new CursoControle();
		try {
			controle.alterarCurso(id, nome, quantVagas);
			JOptionPane.showMessageDialog(null, "Sucesso ao alterar", "Sucesso", 
					JOptionPane.INFORMATION_MESSAGE);
			atualizarTabela();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar", "Erro", 
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	private void remover() {
		long id = Long.parseLong(getTextId().getText());
		CursoControle controle = new CursoControle();
		try {
			controle.removerCurso(id);
			JOptionPane.showMessageDialog(null, "Sucesso ao remover", "Sucesso", 
					JOptionPane.INFORMATION_MESSAGE);
			atualizarTabela();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao remover", "Erro", 
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	
	// tabela - coloquei aqui em baixo para ficar separado dos outros itens da tela.
	
	private JTable tabela;
	private JScrollPane barraRolagem;
	private DefaultTableModel modeloTabela;
	
	private EventoTabela eventoTabela;
		

	private JScrollPane getBarraRolagem() {
		if (barraRolagem == null) {
			barraRolagem = new JScrollPane(getTabela());
			barraRolagem.setBounds(10, 150, 500, 100);
		}
		return barraRolagem;
	}

	private JTable getTabela() {
		if (tabela == null) {
			tabela = new JTable(getModeloTabela());
			tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
			tabela.getColumnModel().getColumn(1).setPreferredWidth(370);
			tabela.getColumnModel().getColumn(2).setPreferredWidth(20);
			tabela.addMouseListener(getEventoTabela());
		}
		return tabela;
	}
	
	private DefaultTableModel getModeloTabela() {
		if (modeloTabela == null) {
			modeloTabela = new DefaultTableModel();
			modeloTabela.addColumn("Id");
			modeloTabela.addColumn("Nome");
			modeloTabela.addColumn("Vagas");
		}
		return modeloTabela;
	}
	
	private void atualizarTabela() {
		getModeloTabela().setNumRows(0); // apaga os dados da tabela
		CursoControle controle = new CursoControle();
		try {
			List<Curso> cursos = controle.listarCurso();
						
			for (Curso c: cursos) {
				Object[] novaLinha = new Object[]{c.getIdCurso(), c.getNome(), c.getQuantidadeVagas()};
				getModeloTabela().addRow(novaLinha); // adiciona uma nova linha na tabela
			}			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Problemas ao listar cursos", "Erro", 
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	private EventoTabela getEventoTabela() {
		if (eventoTabela == null) {
			eventoTabela = new EventoTabela();
		}
		return eventoTabela;
	}
	
	
	
	private void preencherCampos() {
		int linhaSelecionada = getTabela().getSelectedRow();
		if (linhaSelecionada >= 0) {
			long id = (Long) getTabela().getValueAt(linhaSelecionada, 0);
			String nome = (String) getTabela().getValueAt(linhaSelecionada, 1);
			int vagas = (int) getTabela().getValueAt(linhaSelecionada, 2);
			
			getTextId().setText(String.valueOf(id));
			getTextNome().setText(nome);
			getTextVaga().setText(String.valueOf(vagas));
		}
		
	}
	
	private class EventoTabela implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent event) {
			preencherCampos();
			
		}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		public void mousePressed(MouseEvent event) {}
		public void mouseReleased(MouseEvent event) {}
	}
}
