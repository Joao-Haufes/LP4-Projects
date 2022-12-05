package br.com.tlp4.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import br.com.tlp4.jdbc.ConnectionFactory;
import br.com.tlp4.modelo.Aluno;

public class AlunoDAO {
	
	private EntityManager entityManager;

	public AlunoDAO() {
		entityManager = ConnectionFactory.obterConexao();
	}

	public void adicionar(Aluno aluno) throws SQLException {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(aluno);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public void alterar(Aluno aluno) throws SQLException {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(aluno);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public void remover(Aluno aluno) throws SQLException {
		try {
			entityManager.getTransaction().begin();
			// busca a entidade no banco para o hibernate referenciá-la
			Aluno a = entityManager.find(Aluno.class, aluno.getIdAluno());
			entityManager.remove(a);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
}
