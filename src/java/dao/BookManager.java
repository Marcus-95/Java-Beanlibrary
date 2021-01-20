
package dao;

import entity.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class BookManager implements Bookinterface {
    @PersistenceContext
    //ENTITYMANAGER CONNECTS TO THE DATABASE
    EntityManager em;
    
    @Override
    public void addBook(Book b){
        em.persist(b);
    }
    
    @Override
    //GETS ALL DATA FROM BOOK TABLE
    public List<Book> getAllBooks(){
        Query q= em.createQuery("SELECT b FROM Book b");
        return q.getResultList();
    }
    
    @Override
    public void deleteBook(Integer id){
        em.remove(em.find(Book.class,id));
    }
    
    @Override
    public void editBook(Book b, int id) {
       em.find(Book.class,id).setTitle(b.getTitle());
       em.find(Book.class,id).setAuthor(b.getAuthor());
    }

    @Override
    //ORANGE TITLE = USER INPUT
    public List<Book> findTitle(String title) {
       Query q = em.createQuery("SELECT b FROM Book b WHERE b.title='" + title + "'");
        return q.getResultList();
        
    }
    
    @Override
    //ORANGE AUTHOR = USER INPUT
    public List<Book> findAuthor(String author) {
        Query q = em.createQuery("SELECT b FROM Book b WHERE b.author='"+ author + "'");
        return q.getResultList();
    }
    
}
