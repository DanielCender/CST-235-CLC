package business;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Post;

@RequestScoped
@Path("/posts")
@Produces({ "application/xml", "application/json" })
public class PostsRestService implements PostRestServiceInterface {

	@Inject
	private PostBusinessService service;
	
	@GET
	@Path("/{count}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> getCount(@PathParam("count") String count) {
		List<Post> posts = service.getPosts();
		int c = Integer.valueOf(count);
		if(count != null && c <= posts.size() && c > 0) {
			return posts.subList(0, c);
		}
		else {
			return posts;
		}
	}
	

	@GET
	@Path("/post/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Post get(@PathParam("id") String id) {
		return service.get(id);
	}
}