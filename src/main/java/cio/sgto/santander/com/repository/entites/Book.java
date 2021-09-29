package main.java.cio.sgto.santander.com.repository.entites;

import javax.persistence.Entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Book extends PanacheEntity {
			
	
	private String description;
	private String author;
	private String isbn;
	private String thumb;
	private String editorial;
	private String publicationDate;
	private String language;
	private String title;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getThumb() {
		return thumb;
	}
	
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	
	public String getEditorial() {
		return editorial;
	}
	
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public String getPublicationDate() {
		return publicationDate;
	}
	
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public static Book findByTitle(String title){
        return find("title", title).firstResult();
    }
	
}
