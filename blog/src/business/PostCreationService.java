package business;

import beans.Post;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

/**
 * Session Bean implementation class PostCreationService
 */
@Stateless
@Local(PostCreationInterface.class)
@LocalBean
@Alternative
public class PostCreationService implements PostCreationInterface {
	
	private List<Post> posts = new ArrayList<>();

    /**
     * Default constructor. 
     */
    public PostCreationService() {
        //Does not create any posts prior to your first post, as it is supposed to be a personal list of your own posts
    }

	@Override
    public void addPost(Post post) {
        posts.add(post);
    }

	@Override
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

	@Override
    public List<Post> getPosts() {
        return posts;
    }

}
