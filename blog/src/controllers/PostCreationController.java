package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import beans.Post;
import business.PostBusinessInterface;

@ManagedBean
@ViewScoped
public class PostCreationController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PostBusinessInterface postService;
	
	private List<Post> posts;
	
	@PostConstruct
    public void init() {
		System.out.println("**** Ran init ***");
       posts = postService.getPosts();
    }

    public List<Post> getPosts() {
    	System.out.println("**** Ran getPosts now ***");
    	System.out.println("Posts Content Length: " + posts.size());
    	for(Post p : posts) {
    		System.out.println(p.toString());
    	}
        return posts;
    }

	/**
	 * Creates a new post
	 * @param newPost The post the is going to be added
	 * @return A String to either the chooseEditCreatePost.xhtml page for success or to the feed when we have that made
	 */
	public String onSubmit(Post newPost) {
		//add the post
		postService.addPost(newPost);
		System.out.println("Just added " + newPost.toString() + " to posts");
		
		// on success go immediately to login
		return ("chooseEditCreatePosts.xhtml");
	}
}
