package br.com.tlp4.visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import br.com.tlp4.controle.AlunoControle;
import br.com.tlp4.modelo.Curso;

import java.text.SimpleDateFormat;

public class AlunoGUI extends JDialog{
	
	private JPanel painel;
	
	private JLabel labelId;
	private JTextField textId;
	
	private JLabel labelNome;
	private JTextField textNome;
	
	private JLabel labelRa;
	private JTextField textRa;
	
	private JLabel labelCPF;
	private JFormattedTextField textCPF;
	
	private JLabel labelNascimento;
	private JFormattedTextField textNascimento;
	
	private JLabel labelCursos;
	private JComboBox<Curso> comboBoxCursos;
	
	//vínculos
	private JPanel painelVinculo;
	private JRadioButton vinculado;
	private JRadioButton naoVinculado;
	private ButtonGroup grupoVinculado;
	
	
	
	private JButton botaoSalvar;
	private EventoBotoes eventoBotoes ;
	

	public AlunoGUI() {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("Gerenciar Alunos");
		this.setModal(true); // bloqueia a janela principal
		this.setSize(570, 410);
		this.setLocationRelativeTo(null); // centraliza	a tela	
		this.setContentPane(getPainel()); //adiciona painel
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
			painel.add(getLabelCPF());
			painel.add(getTextCPF());
			painel.add(getLabelRa());
			painel.add(getTextRa());
			painel.add(getLabelNascimento());
			painel.add(getTextNascimento());
			painel.add(getLabelCursos());
			painel.add(getComboBoxCursos());
			painel.add(getPainelVinculo());
			painel.add(getBotaoSalvar());
			
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
	
	private JLabel getLabelCPF() {
		
		if (labelCPF == null) {
			labelCPF = new JLabel("CPF: ");
			labelCPF.setBounds(10, 70, 80, 25);
		}
		return labelCPF;
	}

	private JFormattedTextField getTextCPF() {		
		
		if (textCPF == null) {
			MaskFormatter mascara;
			try {
				mascara = new MaskFormatter("###.###.###-##");
				textCPF = new JFormattedTextField(mascara);
				textCPF.setBounds(100, 70, 120, 25);
			} catch (ParseException e) {
				e.printStackTrace();
			}			
		}
		return textCPF;
	}	
	
	private JLabel getLabelRa() {
		
		if (labelRa == null) {
			labelRa = new JLabel("Ra: ");
			labelRa.setBounds(10, 100, 80, 25);
		}
		return labelRa;
	}

	private JTextField getTextRa() {		
		
		if (textRa == null) {
			textRa = new JTextField();
			textRa.setBounds(100, 100, 120, 25);		
		}
		return textRa;
	}	
	
	private JLabel getLabelNascimento() {
		if (labelNascimento == null) {
			labelNascimento = new JLabel("Nascimento: ");
			labelNascimento.setBounds(10, 130, 100, 25);
		}
		return labelNascimento;
	}

	private JFormattedTextField getTextNascimento() {
		if (textNascimento == null) {
			try {
				MaskFormatter mascara = new MaskFormatter("##/##/####");
				textNascimento = new JFormattedTextField(mascara);
				textNascimento.setBounds(100, 130, 80, 25);
			} catch (ParseException e) {
				e.printStackTrace();
			}			
		}
		return textNascimento;
	}

	// criando a combo de cursos
	private JLabel getLabelCursos() {
		if (labelCursos == null) {
			labelCursos = new JLabel("Curso: ");
			labelCursos.setBounds(10, 160, 80, 25);
		}
		return labelCursos;
	}

	private JComboBox<Curso> getComboBoxCursos() {
		if (comboBoxCursos == null) {
			comboBoxCursos = new JComboBox<Curso>();
			comboBoxCursos.setBounds(100, 160, 300, 25);
			AlunoControle ac = new AlunoControle();
			try {
				List<Curso> cursos = ac.listarCurso();
				for (Curso c : cursos) {
					comboBoxCursos.addItem(c);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return comboBoxCursos;
	}

	
	
	
	// criando o painel de vínculo
	private JPanel getPainelVinculo() {
		if (painelVinculo == null) {
			painelVinculo = new JPanel( );
			painelVinculo.setBorder(BorderFactory.createTitledBorder("Vinculado?"));
			painelVinculo.setBounds(10, 190, 140, 50);
			painelVinculo.add(getVinculado());
			painelVinculo.add(getNaoVinculado());
			getGrupoVinculado();// é apenas um agrupamento que não é adicionado no painel
		}
		return painelVinculo;
	}

	private JRadioButton getVinculado() {
		if (vinculado == null) {
			vinculado = new JRadioButton("Sim");
		}
		return vinculado;
	}

	private JRadioButton getNaoVinculado() {
		if (naoVinculado == null) {
			naoVinculado = new JRadioButton("Não", true);
		}
		return naoVinculado;
	}

	private ButtonGroup getGrupoVinculado() {
		if (grupoVinculado == null) {
			grupoVinculado = new ButtonGroup();
			grupoVinculado.add(getVinculado());
			grupoVinculado.add(getNaoVinculado());
		}
		return grupoVinculado;
	}
	
	
	private JButton getBotaoSalvar() {
		if(botaoSalvar == null){
			botaoSalvar = new JButton("Salvar");
			botaoSalvar.setToolTipText("clique aqui para salvar");
			botaoSalvar.setBounds(30, 250, 100, 25);
			botaoSalvar.addActionListener(getEventoBotoes());
		}
		return botaoSalvar;
	}
	
	private EventoBotoes getEventoBotoes() {
		if (eventoBotoes ==  null) {
			eventoBotoes = new EventoBotoes();
		}		
		return eventoBotoes;
	}
	
	private class EventoBotoes implements ActionListener{		
		public void actionPerformed(ActionEvent evento) {			
			if(evento.getSource() == getBotaoSalvar()){
				salvar();
			}
		}		
	}

	private boolean estaVinculado(){
		boolean vinculado = false;
		if (getVinculado().isSelected()) {
			vinculado = true;
		}else if (getNaoVinculado().isSelected()) {
			vinculado = false;
		}
		return vinculado;
	}
	private void salvar() {
		boolean temVinculo = estaVinculado();		
		Curso curso = (Curso) getComboBoxCursos().getSelectedItem();
		String nome = getTextNome().getText();
		String cpf = getTextCPF().getText();
		String ra = getTextRa().getText();
		
		String nascimento = getTextNascimento().getText();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date nascimentoData = null;
		try {
			nascimentoData = sdf.parse(nascimento);
			AlunoControle controle = new AlunoControle();
			controle.adicionar(curso, nome, cpf, ra, temVinculo, nascimentoData);
			JOptionPane.showMessageDialog(null, "Sucesso ao gravar aluno", "Sucesso", 
					JOptionPane.INFORMATION_MESSAGE);
		} catch (ParseException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao gravar aluno", "Erro", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
