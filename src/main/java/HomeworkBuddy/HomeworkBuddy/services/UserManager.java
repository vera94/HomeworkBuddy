package HomeworkBuddy.HomeworkBuddy.services;


import HomeworkBuddy.HomeworkBuddy.dao.UserDAO;
import HomeworkBuddy.HomeworkBuddy.model.Homework;
import HomeworkBuddy.HomeworkBuddy.model.User;

import java.net.HttpURLConnection;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




@Stateless
@Path("/user")
public class UserManager {
    
    private static final Response RESPONSE_OK = Response.ok().build();

    @Inject
    private UserDAO userDAO;
    
    @Inject
    private UserContext context;

	@Path("/register")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerUser(User newUser) {
		userDAO.addUser(newUser);
		context.setCurrentUser(newUser);
	}

    
    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginUser(User user) {
        boolean isUserValid = userDAO.validateUserCredentials(user.getUserName(), user.getPassword());
        if (!isUserValid) {
            return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).build();
        }
        context.setCurrentUser(user);
        return RESPONSE_OK;
    }
    
    @Path("authenticated")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response isAuthenticated() {
        if (context.getCurrentUser() == null) {
            return Response.status(HttpURLConnection.HTTP_NOT_FOUND).build();
        }
        return RESPONSE_OK;
    }

    @Path("currentUsr")
    @GET
    @Produces("application/json")
    public User getUserObj() {
        if (context.getCurrentUser() == null) {
            return null;
        }
        return context.getCurrentUser();
    }
    
    @Path("allUsers")
    @GET
    @Produces("application/json")
    public Collection<User> getAllHomeworks() {
        return userDAO.getAllUsers();
    }
    
    @Path("current")
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    public String getUser() {
        if (context.getCurrentUser() == null) {
            return null;
        }
        return context.getCurrentUser().getUserName();
    }

	@Path("logout")
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	public void logoutUser() {
		context.setCurrentUser(null);
	}
}
