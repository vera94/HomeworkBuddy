package HomeworkBuddy.HomeworkBuddy.utils;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import HomeworkBuddy.HomeworkBuddy.dao.HomeworkDAO;
import HomeworkBuddy.HomeworkBuddy.dao.UserDAO;
import HomeworkBuddy.HomeworkBuddy.model.Homework;
import HomeworkBuddy.HomeworkBuddy.model.User;

@Stateless
public class DatabaseUtils {
    
/*    private static User[] USERS = {
            new User("Vera", "123456", "vera@mail.com", "Vera", "Vera", "Vera", "Vera", "Vera", 2, 30)};

    private static Homework[] HOMEWORKS = {
            new Homework("The Old Man and the Sea", "Ernest Hemingway",
                    "978-3-16-148410-0", 5),
            new Homework("Tom Sawyer", "Mark Twain", "978-4-16-241512-0", 0)};*/

    @PersistenceContext
    private EntityManager em;

    @EJB
    private HomeworkDAO homeworkDAO;
    
    @EJB
    private UserDAO userDAO;
    
/*    public void addTestDataToDB() {
        deleteData();
        addTestUsers();
        addTestBooks();
    }

    private void deleteData() {
        em.createQuery("DELETE FROM Homework").executeUpdate();
        em.createQuery("DELETE FROM User").executeUpdate();
   }

    private void addTestUsers() {
        for (User user : USERS) {
            userDAO.addUser(user);
        }
    }

    private void addTestBooks() {
        for (Book book : BOOKS) {
            bookDAO.addBook(book);
        }
    }*/
}
