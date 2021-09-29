package main.java.cio.sgto.santander.com.services.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import main.java.cio.sgto.santander.com.repository.entites.Book;

@ApplicationScoped
public class BookService {

	@Inject
    EntityManager em; 
	
	
	@Transactional 
    public void createBook(Book book) {            
        em.persist(book);
    }
	
	
	@Transactional 
    public void updateBook(Book book) {            
        em.persist(book);
    }
	
	
	
	
	
	
}
