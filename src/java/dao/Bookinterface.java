
package dao;

import entity.Book;
import java.util.List;

//Class for CRUD-methods

public interface Bookinterface {
    
    //Add
    public void addBook(Book b);
    
    //Get
    public List<Book> getAllBooks();
    
    //Delete
    public void deleteBook(Integer id);
    
    //Edit
    public void editBook(Book b,int id);
    
    //Search by title
    public List<Book> findTitle(String title);
    
    //Search by author
    public List<Book> findAuthor(String author);
    
}
