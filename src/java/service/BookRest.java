package service;


import entity.Book;
import dao.Bookinterface;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Stateless
@Path("entity.Book")
public class BookRest {
    @Inject 
    Bookinterface bi;

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void addBook(Book b){
        bi.addBook(b);
    }
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Book> getAll(){
        return bi.getAllBooks();
    }
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void edit(@PathParam("id") Integer id, Book t){
        bi.editBook(t, id);
    }
    

    @DELETE
    @Path("{id}")
    public void deleteBook(@PathParam("id") Integer id){
        bi.deleteBook(id);
    }

}