
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    //VARIABLES
    private int id;
    private String author;
    private String title;
    
    
    //CONSCTRUCTOR
     public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
     
    public Book(){       
    }
    //GETTERS AND SETTERS
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //END OF GET AND SET
    

    @Override
    public String toString() {
        return "entity.Book[ id=" + id + " ]";
    }
    
}
