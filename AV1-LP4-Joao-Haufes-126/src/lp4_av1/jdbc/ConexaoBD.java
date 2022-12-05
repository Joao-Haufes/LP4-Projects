package lp4_av1.jdbc;

import javax.persistence.*;

public class ConexaoBD {
    public static EntityManager getConexao(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lp4_av1");
        return factory.createEntityManager();
    }
}
