package br.com.tlp4.jdbc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	public static EntityManager obterConexao(){
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernateLP4");
		 return factory.createEntityManager();
	}

}
