package JDBC;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	
	public static EntityManager obterconexao(){
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernateLP4");
		 return factory.createEntityManager();
	}
}
