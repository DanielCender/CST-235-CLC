package business;

import beans.Post;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class PostBusinessService
 */
@Stateless
@Local(PostBusinessInterface.class)
@LocalBean
public class PostBusinessService implements PostBusinessInterface {
	private Post post; 
    /**
     * Default constructor. 
     */
    public PostBusinessService() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see PostBusinessInterface#createPost(Post)
     */
    public void createPost(Post post) {
        // TODO Auto-generated method stub
    	// TODO Database operation here
    	this.post = post;
    }

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

//	/**
//     * @see PostBusinessInterface#setPosts(List<Post>)
//     */
//    public void setPosts(List<Post> posts) {
//    	this.createPost(post);
//    }
//
//	/**
//     * @see PostBusinessInterface#getPosts()
//     */
//    public List<Post> getPosts() {
//        // TODO Auto-generated method stub
//			return null;
//    }

}
