package br.com.tlp4.controle;

import java.sql.SQLException;
import java.util.List;

import br.com.tlp4.dao.CursoDAO;
import br.com.tlp4.modelo.Curso;

public class CursoControle {
	
	public void salvarCurso(String nome, int vagas) throws SQLException {
		Curso curso = new Curso();
		curso.setNome(nome);
		curso.setQuantidadeVagas(vagas);
		
		CursoDAO dao = new CursoDAO();
		dao.adicionar(curso);
	}
	
	public void alterarCurso(long id, String nome, int vagas) throws SQLException {
		Curso curso = new Curso();
		curso.setNome(nome);
		curso.setQuantidadeVagas(vagas);
		curso.setIdCurso(id);		
		CursoDAO dao = new CursoDAO();
		dao.alterar(curso);
	}
	
	public void removerCurso(long id) throws SQLException {
		Curso curso = new Curso();
		curso.setIdCurso(id);		
		CursoDAO dao = new CursoDAO();
		dao.remover(curso);
	}

	public List<Curso> listarCurso() throws SQLException {
		CursoDAO dao = new CursoDAO();		
		return dao.selecionarTodos();
	}

}
