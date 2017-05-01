package blackjack.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import blackjack.model.Table;

public class Memento { 
	//Memento
	private Table Table;
	
	//save state
	public Memento(Table state){ 
		Table = state;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory .openSession();
		session.beginTransaction(); 
		session.save(Table);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	//get state
	public Table getState(){
		return Table;
	}
	
	

	
}
