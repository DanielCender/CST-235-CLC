package business;

import java.util.List;

import javax.ejb.Local;

import beans.Post;

@Local
public interface PostCreationInterface {

	public List<Post> getPosts();
	
	public void setPosts(List<Post> posts);
	
	public void addPost(Post post);
	
}
