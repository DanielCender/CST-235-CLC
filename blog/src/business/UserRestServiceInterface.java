package business;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.User;

@RequestScoped
@Path("/users")
@Produces({ "application/xml", "application/json" })
public interface UserRestServiceInterface {

	@GET
	@Path("/{count}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAll(@PathParam("count") int count);
	
	@GET
	@Path("/user/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public User get(@PathParam("email") String email);
}
