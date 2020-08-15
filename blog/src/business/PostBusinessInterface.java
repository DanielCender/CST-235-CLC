package business;

import java.util.List;

import javax.ejb.Local;

import beans.Post;

/**
 * 
 * Interface designed for business logic handling post CRUD operations
 *
 */
@Local
public interface PostBusinessInterface {

	public List<Post> getPosts();
	
	public void setPosts(List<Post> posts);
	
	public void addPost(Post post);
	
	public void update(String id, Post t);

	public Post get(String id);
	
	public void deletePost(String id, Post t);
}
