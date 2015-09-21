package HomeworkBuddy.HomeworkBuddy.services;

import HomeworkBuddy.HomeworkBuddy.dao.HomeworkDAO;
import HomeworkBuddy.HomeworkBuddy.model.Homework;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;


@Stateless
@Path("/homework")
public class HomeworkManager {
	private static final Response RESPONSE_OK = Response.ok().build();
    @Inject
    private HomeworkDAO homeworkDAO;

    @Inject
    private UserContext userContext;

    @GET
    @Path("/getHomeworks")
    @Produces("application/json")
    public Collection<Homework> getAllHomeworks() {
        return homeworkDAO.getAllHomeworks();
    }
    
    @POST
    @Path("/addHomework")
    @Produces("application/json")
    public Response addHomework(Homework homework) {
        homeworkDAO.addHomework(homework);
        return RESPONSE_OK;
    }

    @GET
    @Path("{homeworkId}")
    @Produces("application/json")
    public Homework getHomework(@PathParam("homeworkId") String homeworkId) {
        return homeworkDAO.findById(Long.parseLong(homeworkId));
    }


}
