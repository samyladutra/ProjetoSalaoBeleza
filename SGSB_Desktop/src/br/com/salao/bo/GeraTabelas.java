package br.com.salao.bo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class GeraTabelas {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");
		
		factory.close();
	}

}
