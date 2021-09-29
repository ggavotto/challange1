package main.java.cio.sgto.santander.com.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import main.java.cio.sgto.santander.com.repository.entites.Book;

@Path("/library")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookController {

	@GET
    public List<Book> list() {
        return Book.listAll();
    }

    @GET
    @Path("/{id}")
    public Book get(@PathParam("id") Long id) {
        return Book.findById(id);
    }

    @POST
    @Transactional
    public Response create(Book book) {
        book.persist();
        return Response.created(URI.create("/books/" + book.getId())).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Book update(@PathParam("id") Long id, Book book) {
        Book entity = Book.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        
        entity.setTitle(book.getTitle());
        
        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        Book entity = Book.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
    }

    @GET
    @Path("/search/{title}")
    public Book search(@PathParam("title") String title) {
        return Book.findByTitle(title);
    }

    @GET
    @Path("/count")
    public Long count() {
        return Book.count();
    }
	
}
