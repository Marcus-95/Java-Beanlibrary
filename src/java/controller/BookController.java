
package controller;

import dao.Bookinterface;
import entity.Book;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


@Named(value = "bookController")
@RequestScoped
public class BookController {

    @Inject
    //CONNECT TO THE DATABASE
    Bookinterface bm;

    //ALL VARIABLES
    private int id;
    private String title;
    private String author;
    private List<Book> allBooks;
    private int count;
    private String searchAuthor;
    private String searchTitle;

    
    //GETTERS AND SETTERS BELOW
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }
    

    public String getSearchAuthor() {
        return searchAuthor;
    }

    public void setSearchAuthor(String searchAuthor) {
        this.searchAuthor = searchAuthor;
    }
    
    public List<Book> getAllBooks() {
        return allBooks;
    }
    public void setAllBooks(List<Book> allBooks) {
        this.allBooks = allBooks;
    }
    
 
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    //END OF GETTERS AND SETTERS
    
    
    //METHODS
    @PostConstruct
    //GETS EMPTY LIST AND FILLS IT WITH ALL BOOKS/DATA IN BOOK TABLE
    public void fillBooks(){
        this.allBooks= bm.getAllBooks();
        count = allBooks.size();
    }
    
    public void update(int id){
        //CREATES A NEW BOOK OBJECT AND FILLS IT WITH NEW DATA FROM EDITBOOK METHOD
        Book book = new Book(searchTitle, searchAuthor);
        bm.editBook(book, id);
        //ALLBOOKS UPDATES APPTABLE AFTER EVERY UPDATE
        allBooks = bm.getAllBooks();       
    }
    
    public void submit(){
        Book book = new Book(title,author);
        bm.addBook(book);
        allBooks = bm.getAllBooks();
        count = allBooks.size();
    }
    
    public void delete(int id){
        bm.deleteBook(id);
        allBooks = bm.getAllBooks();
        count = allBooks.size();
    }
    
 
    public void searchAuthor1(){
        allBooks =bm.findAuthor(searchAuthor);
        count = allBooks.size();
    }
    
    public void searchTitle1(){
        allBooks =bm.findTitle(searchTitle);
        count = allBooks.size();
    }
   
    public BookController() {
    }
    
}
