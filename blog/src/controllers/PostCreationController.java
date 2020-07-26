package controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import beans.Post;
import beans.User;
import beans.UserAuthentication;
import business.OrdersBusinessInterface;
import business.PostBusinessService;

@ManagedBean(name="PostCreationController")
@ViewScoped
public class PostCreationController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PostBusinessService postService;
	
	public PostBusinessService getPostService() {
		return postService;
	}
	
	// temporary field to hold persistent list of posts. Probably will not hold new
	// values between runs. Must have a setter to work properly.
	@ManagedProperty(value = "#{post}")
	private Post post;
	
	// Setter for injected bean
	public void setPosts(Post post) {
		this.post = post;
	}

	/**
	 * Creates a new post
	 * @param newPost The post the is going to be added
	 * @return A String to either the chooseEditCreatePost.xhtml page for success or to the feed when we have that made
	 */
	public String onSubmit(Post newPost) {
		FacesContext fc = FacesContext.getCurrentInstance();
		
		fc.getExternalContext().getRequestMap().put("post", newPost);		
		
		// add the post using business interface
		postService.createPost(newPost);
		
		// on success go immediately to login
		return ("chooseEditCreatePosts.xhtml");
	}
	
}
