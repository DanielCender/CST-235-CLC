package business;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Post;

/**
 * 
 * Interface for REST business services on blog posts.
 *
 */
@RequestScoped
@Path("/posts")
@Produces({ "application/xml", "application/json" })
public interface PostRestServiceInterface {
	
	@GET
	@Path("/{count}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> getCount(@PathParam("count") String count);
	
	@GET
	@Path("/post/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Post get(@PathParam("id") String id);
}
