package jdbc;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	public static EntityManager getConnection(){
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateLP4");
		 return factory.createEntityManager();
	}
}
