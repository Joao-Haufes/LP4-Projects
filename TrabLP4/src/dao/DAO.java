package dao;

import java.sql.SQLException;
import jdbc.ConnectionFactory;
import modelo.Produto;
import javax.persistence.EntityManager;
import java.util.List;


public class DAO {
	private EntityManager entityManager;

	public DAO() {
		this.entityManager = ConnectionFactory.getConnection();
	}

	public void adicionar(Produto produto) throws SQLException {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(produto);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void alterar(Produto produto) throws SQLException {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(produto);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remover(Produto prod) throws SQLException {
		Produto produto;

		try {
			entityManager.getTransaction().begin();
			produto = entityManager.find(Produto.class, prod.getIdProduto());
			entityManager.remove(produto);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public List<Produto> selecionarTudo() throws SQLException {
		List<Produto> listProd = null;

		try {
			entityManager.getTransaction().begin();
			listProd = entityManager.createQuery("SELECT prod FROM Produto prod", Produto.class).getResultList();
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return listProd;
	}
}

