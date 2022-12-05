package br.com.tlp4;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.tlp4.dao.AlunoDAO;
import br.com.tlp4.dao.CursoDAO;
import br.com.tlp4.modelo.Aluno;
import br.com.tlp4.modelo.Curso;
import br.com.tlp4.visao.TelaPrincipal;

public class MainAPP {
	/*
	public static void mostrarCursos() {
		try {
			CursoDAO cursoDAO = new CursoDAO();
			List <Curso> cursos = cursoDAO.selecionarTodos();
			for (Curso c : cursos) {
				System.out.println(c.getNome());
				for (Aluno a: c.getAlunos()) {
					System.out.println("\t"+ a.getNome());
				}				
			}			
		} catch (SQLException e) {
			System.out.println("Problemas ao selecionar o curso.");
			e.printStackTrace();
		}
	}
	
	public static void adicionarAlunoEmCurso(Aluno alu, long idCurso) {
		try {
			CursoDAO cursoDAO = new CursoDAO();
			Curso curso = cursoDAO.selecionarCurso(idCurso);
			alu.setCurso(curso);			
			AlunoDAO alunoDAO = new AlunoDAO();
			alunoDAO.adicionar(alu);			
		} catch (SQLException e) {
			System.out.println("Problemas ao adicionar aluno no curso.");
			e.printStackTrace();
		}	
	}
	
	public static void removerCurso(long id) {
		try {
			CursoDAO cursoDAO = new CursoDAO();
			Curso curso = new Curso();
			curso.setIdCurso(id);
			cursoDAO.remover(curso);			
		} catch (SQLException e) {
			System.out.println("Problemas ao remover o curso.");
			e.printStackTrace();
		}	
	}
	
	public static void alterarAluno(Aluno alu) {
		try {
			AlunoDAO alunoDAO = new AlunoDAO();
			alunoDAO.alterar(alu);			
		} catch (SQLException e) {
			System.out.println("Problemas ao alterar aluno.");
			e.printStackTrace();
		}	
	}
	
	public static void removerAluno(Aluno alu) {
		try {
			AlunoDAO alunoDAO = new AlunoDAO();
			alunoDAO.remover(alu);			
		} catch (SQLException e) {
			System.out.println("Problemas ao remover aluno.");
			e.printStackTrace();
		}	
	}
	*/
	public static void main(String[] args) {
		
		TelaPrincipal tela = new TelaPrincipal();	
		
		
		
	}
}
