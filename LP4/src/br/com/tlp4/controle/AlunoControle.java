package br.com.tlp4.controle;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import br.com.tlp4.dao.AlunoDAO;
import br.com.tlp4.dao.CursoDAO;
import br.com.tlp4.modelo.Aluno;
import br.com.tlp4.modelo.Curso;

public class AlunoControle {	
	
	public List<Curso> listarCurso() throws SQLException{
		CursoDAO dao = new CursoDAO();
		return dao.selecionarTodos();
	}
	
	public void adicionar(Curso curso, String nome, String cpf, String ra, boolean vinculado, Date nascimento) throws SQLException {
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setRa(ra);
		aluno.setEstaVinculado(vinculado);
		aluno.setNascimento(nascimento);
		
		aluno.setCurso(curso);
		
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.adicionar(aluno);
	}

}
