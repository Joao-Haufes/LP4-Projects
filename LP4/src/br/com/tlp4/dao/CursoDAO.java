package br.com.tlp4.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.tlp4.jdbc.ConnectionFactory;
import br.com.tlp4.modelo.Curso;

import javax.persistence.EntityManager;

public class CursoDAO {

	private EntityManager entityManager;

	public CursoDAO() {
		entityManager = ConnectionFactory.obterConexao();
	}

	public void adicionar(Curso curso) throws SQLException {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(curso);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void alterar(Curso curso) throws SQLException {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(curso);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remover(Curso curso) throws SQLException {
		try {
			entityManager.getTransaction().begin();
			// busca a entidade no banco para o hibernate referenciá-la
			Curso c = entityManager.find(Curso.class, curso.getIdCurso());
			entityManager.remove(c);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public List<Curso> selecionarTodos() throws SQLException {
		List<Curso> cursos = null;
		try {
			// Hibernate Query Language (HQL)
			entityManager.getTransaction().begin(); // select * from curso
			cursos = entityManager.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return cursos;
	}

	public Curso selecionarCurso(Long id) throws SQLException {
		Curso curso = null;
		try {
			entityManager.getTransaction().begin();
			curso = entityManager.find(Curso.class, id);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return curso;
	}
}
