package controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import beans.Post;
import business.PostCreationInterface;

@ManagedBean
@ViewScoped
public class PostCreationController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PostCreationInterface posts;
	
	public PostCreationInterface getPosts() {
		return posts;
	}

	/**
	 * Creates a new post
	 * @param newPost The post the is going to be added
	 * @return A String to either the chooseEditCreatePost.xhtml page for success or to the feed when we have that made
	 */
	public String onSubmit(Post newPost) {
		//add the post
		posts.addPost(newPost);
		System.out.println("Just added " + newPost.toString() + " to posts");
		
		// on success go immediately to login
		return ("chooseEditCreatePosts.xhtml");
	}
	
}
