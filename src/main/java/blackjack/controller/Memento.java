package blackjack.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import blackjack.model.Table;

public class Memento { 
	//Memento
	private Table Table;
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory .openSession();
	
	//save state
	public Memento(Table state){ 
		Table = state;
		session.beginTransaction(); 
		session.save(Table);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	//gets most recent state
	public Table getState(){
		session.beginTransaction(); 
		Table = sessionFactory.getCurrentSession().get(Table.class, 1); 
		session.close();
		return Table;
	}
	
	

	
}
