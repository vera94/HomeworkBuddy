package HomeworkBuddy.HomeworkBuddy.services;

import HomeworkBuddy.HomeworkBuddy.dao.HomeworkDAO;
import HomeworkBuddy.HomeworkBuddy.model.Homework;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;


@Stateless
@Path("homework")
public class HomeworkManager {

    @Inject
    private HomeworkDAO homeworkDAO;

    @Inject
    private UserContext userContext;

/*    @GET
    @Produces("application/json")
    public Collection<Homework> getAllHomeworks() {
        return homeworkDAO.getAllHomeworks().getResultList();
    }*/

    @GET
    @Path("{homeworkId}")
    @Produces("application/json")
    public Homework getHomework(@PathParam("homeworkId") String homeworkId) {
        return homeworkDAO.findById(Long.parseLong(homeworkId));
    }


}
