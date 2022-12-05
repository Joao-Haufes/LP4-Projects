package DAO;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import JDBC.Conexao;
import Modelo.Produto;

public class ProdutoDAO {
	private EntityManager entityManager;

	public ProdutoDAO() {
		entityManager = Conexao.obterconexao();
		
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
	
	public void deletar(Produto produto) throws SQLException {
		try {
			entityManager.getTransaction().begin();
			Produto p = entityManager.find(Produto.class, produto.getIdProduto());
			entityManager.remove(p);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public List<Produto> mostarProdutos() throws SQLException {
		List<Produto> produto = null;
		try {
			entityManager.getTransaction().begin();
			produto = entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return produto;
	}
	
}
