package HomeworkBuddy.HomeworkBuddy.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "findByTitleAndAuthor", query = "SELECT b FROM Homework b WHERE b.title = :title AND b.description = :author"),
        @NamedQuery(name = "getAllHomeworks", query = "SELECT b FROM Homework b")})
public class Homework implements Serializable {

    private static final long serialVersionUID = -2929008106626811914L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    
    private String subject;

    private String teacher;

    private String description;
    
    private Date startDate;

    private Date endDate;
    
    private Date lastModified;
    
    private String spec;
    
    private Integer year;

    public Homework() {
    }

    public Homework(String title, String subject, String description, Date endDate, String teacher, String spec) {
        super();
        this.title = title;
        this.teacher = teacher;
        this.subject = subject;
        this.description = description;
        this.startDate = new Date();        
        this.endDate = endDate;
        this.lastModified = this.startDate;
        this.spec = spec;
        
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String descr) {
        this.description= descr ;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    
    public String getTeacher() {
        return teacher;
    }

    public Date getStartDate() {
        return startDate;
    }
    
    public Date getEndDate() {
        return endDate;
    }
    
    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
//TODO
/*    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (title != null && !title.trim().isEmpty())
            result += "title: " + title;
        if (author != null && !author.trim().isEmpty())
            result += ", author: " + author;
        if (isbn != null && !isbn.trim().isEmpty())
            result += ", isbn: " + isbn;
        result += ", amount: " + amount;
        return result;
    }*/

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Homework)) {
            return false;
        }
        Homework other = (Homework) obj;
        if (id != null) {
            if (!id.equals(other.id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}