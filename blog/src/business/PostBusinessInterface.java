package business;

import java.util.List;

import javax.ejb.Local;

import beans.Post;

@Local
public interface PostBusinessInterface {
//	public List<Post> getPosts();
//	public void setPosts(List<Post> posts); 
	public void createPost(Post post);
	public Post getPost();
}
