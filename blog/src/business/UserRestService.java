package business;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.User;

@RequestScoped
@Path("/users")
@Produces({ "application/xml", "application/json" })
public class UserRestService implements UserRestServiceInterface {

	@Inject
	private UserAuthenticationService service;
	
	@GET
	@Path("/{count}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAll(@PathParam("count") int count) {
		List<User> users = service.getUserList();
		if(count <= users.size() && count > 0) {
			return users.subList(0, count);
		}
		else {
			return users;
		}
	}
	
	@GET
	@Path("/user/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public User get(@PathParam("email") String email) {
		return service.getUser(email);
	}
}
