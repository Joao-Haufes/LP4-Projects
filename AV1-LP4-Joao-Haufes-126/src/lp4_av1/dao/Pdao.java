package lp4_av1.dao;

import java.util.List;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import lp4_av1.jdbc.ConexaoBD;
import lp4_av1.Pedido;

public class Pdao {
    private EntityManager entityManager;

    public Pdao() {
        this.entityManager = ConexaoBD.getConexao();
    }

    public void adicionar(Pedido ped) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(ped);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void alterar(Pedido ped) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(ped);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void deletar(Pedido ped) throws SQLException {
        Pedido p;

        try {
            entityManager.getTransaction().begin();
            p = entityManager.find(Pedido.class, ped.getSequenceId());
            entityManager.remove(p);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public List<Pedido> selecionarTD() throws SQLException {
        List<Pedido> listPedidos;

        try {
            entityManager.getTransaction().begin();
            listPedidos = entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            listPedidos = null;
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return listPedidos;
    }

    public Pedido selecionarP(Long id) throws SQLException {
        Pedido p;

        try {
            entityManager.getTransaction().begin();
            p = entityManager.find(Pedido.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            p = null;
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return p;
    }
}
