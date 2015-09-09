package HomeworkBuddy.HomeworkBuddy.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@XmlRootElement
@Table(name = "USERS")
public class User implements Serializable {

    private static final long serialVersionUID = -7196507424378163030L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String password;

    private String email;
    
    private String number;
    
    private String fullName;
    
    private Boolean isTeacher;

    private String faculty;
    
    private String  speciality;
    
    private Integer year;
    
    private Integer facNum;
    
    private String teacherKey = "1234abcd";

    @OneToMany
    private Set<Homework> currentHomeworks = new HashSet<>();

    public User() {
    }

    public User(String userName, String password, String fullName, String email, String number, String isTeacher, 
    		String faculty, String speciality, int year, int facNum ) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.number = number;
        if(isTeacher.equals(teacherKey)){
        	this.isTeacher = true;
        }
        this.faculty = faculty;
        this.speciality = speciality;
        this.year = year;
        this.facNum = facNum; 
        
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    public Boolean getIsTeacher(){
    	return isTeacher;
    }
    
    public void setIsTeacher(Boolean isTeacher){
    	this.isTeacher = isTeacher;
    }
    
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    
    public Integer getYear(){
    	return year;
    }
    
    public void setYear(Integer year){
    	this.year = year;
    }
    
    public Integer getFacNum(){
    	return facNum;
    }
    
    public void setFacNum(Integer facNum){
    	this.facNum = facNum;
    }
    
    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (userName != null && !userName.trim().isEmpty())
            result += "userName: " + userName;
        if (password != null && !password.trim().isEmpty())
            result += ", password: " + password;
        if (email != null && !email.trim().isEmpty())
            result += ", email: " + email;
        return result;
    }

    public Set<Homework> getCurrentHomeworks() {
        return this.currentHomeworks;
    }

    public void setCurrentHomeworks(final Set<Homework> currentHomeworks) {
        this.currentHomeworks = currentHomeworks;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
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
}