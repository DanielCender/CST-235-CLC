package business;

import beans.Post;
import data.PostDataAccessInterface;

//import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * Session Bean implementation class PostCreationService
 */
@Named
@Stateless
@Local(PostBusinessInterface.class)
@LocalBean
public class PostBusinessService implements PostBusinessInterface {
	
	@Inject
	private PostDataAccessInterface<Post> dao;

    /**
     * Default constructor. 
     */
    public PostBusinessService() {
        //Does not create any posts prior to your first post, as it is supposed to be a personal list of your own posts
    }

	@Override
    public void addPost(Post post) {
        dao.save(post);
    }

	@Override
    public void setPosts(List<Post> posts) {
        for(Post p : posts) {
        	dao.save(p);
        }
    }

	@Override
    public List<Post> getPosts() {
		return dao.getAll();
    }
	
	@Override public void update(String id, Post t) {
		dao.update(id, t);
	}
	
	@Override
	public Post get(String id) {
		return dao.get(id);
	}
}
