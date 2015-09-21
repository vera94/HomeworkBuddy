package HomeworkBuddy.HomeworkBuddy.dao;

import java.util.Collection;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import HomeworkBuddy.HomeworkBuddy.model.Homework;
import HomeworkBuddy.HomeworkBuddy.model.User;

@Singleton
public class HomeworkDAO {

    @PersistenceContext
    private EntityManager em;

    public void addHomework(Homework homework) {
//    	Homework foundHomework = findByTitleAndSubject(homework.getTitle(), homework.getSubject());
//        if (foundHomework == null) {
//            em.persist(homework);
//        } 
    	em.persist(homework);
    }
    
    public void removeHomework(Homework homework) {
    	List<Homework> foundHomework = findBySpecAndYear(homework.getSpec(), homework.getYear());
        if (foundHomework != null) {
            em.remove(homework);
        }
    }

    public Homework findById(long key) {
        return em.find(Homework.class, key);
    }

    public Collection<Homework> findByTeacher(String teacher){
    	return em.createNamedQuery("findByTeacher", Homework.class).setParameter("teacher", teacher).getResultList();
    }
    
    public List<Homework> findBySpecAndYear(String title, Integer year) {
        try {
            return em
                    .createNamedQuery("findByTitleAndSubject", Homework.class)
                    .setParameter("title", title).setParameter("year", year).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

	public Collection<Homework> getAllHomeworks() {
		 String query ="SELECT h FROM Homework h";
		 return em.createQuery(query, Homework.class).getResultList();
	}

 /*   public void submitHomework(Homework bookToBorrow, User userWhoTakesTheBook) {
        Book foundBook = findById(bookToBorrow.getId());
        int newAmount = foundBook.getAmount() - 1;
        foundBook.setAmount(newAmount);
        userWhoTakesTheBook.getCurrentBooks().add(foundBook);
    }

    public void returnBook(Book book, User user) {
        Book foundBook = findById(book.getId());
        int newAmount = book.getAmount() + 1;
        foundBook.setAmount(newAmount);
        User userWhoReturnsTheBook = em.find(User.class, user.getId());
        userWhoReturnsTheBook.getCurrentBooks().remove(foundBook);
    }*/

}
