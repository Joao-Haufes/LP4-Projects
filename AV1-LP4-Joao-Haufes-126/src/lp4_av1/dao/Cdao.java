package lp4_av1.dao;

import java.util.List;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import lp4_av1.jdbc.ConexaoBD;
import lp4_av1.Cliente;

public class Cdao {
    private EntityManager entityManager;

    public Cdao() {
        this.entityManager = ConexaoBD.getConexao();
    }

    public void adicionar(Cliente client) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(client);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void alterar(Cliente client) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(client);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void deletar(Cliente client) throws SQLException {
        Cliente c;

        try {
            entityManager.getTransaction().begin();
            c = entityManager.find(Cliente.class, client.getSequenciaId());
            entityManager.remove(c);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public List<Cliente> selecionarTD() throws SQLException {
        List<Cliente> listClientes;

        try {
            entityManager.getTransaction().begin();
            listClientes = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            listClientes = null;
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return listClientes;
    }

    public Cliente selecionarC(Long idClient) throws SQLException {
        Cliente c;

        try {
            entityManager.getTransaction().begin();
            c = entityManager.find(Cliente.class, idClient);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            c = null;
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return c;
    }
}
