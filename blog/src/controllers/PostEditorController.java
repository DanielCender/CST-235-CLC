package controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import beans.Post;
import beans.User;
import business.PostBusinessInterface;
import business.UserAuthenticationService;

@ManagedBean
@ViewScoped
public class PostEditorController  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PostBusinessInterface postService;
	@Inject
	private UserAuthenticationService userService;
	
	private Post toEdit;
	
	public Post getToEdit() {
		return toEdit;
	}
	
	private User author;
	
	public User getAuthor() {
		return author;
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("Running init for editor controller");
	    String postId = FacesContext.getCurrentInstance()
	        .getExternalContext().getRequestParameterMap().get("id");
	    System.out.println("Post id received: " + postId);
	    if (postId != null) {
	        toEdit = postService.get(postId);
	        System.out.println("To Edit: " + toEdit.toString());
	        author = userService.getUser(toEdit.getAuthorId());
	        System.out.println("To Edit - Author: " + author.toString());
	    }
	}
	
	/**
	 * Updates an existing post
	 * @param updatedPost
	 * @return A string designating a return xhtml page
	 */
	public String onEdit(Post updatedPost) {
		System.out.println("Updated post item: " + updatedPost);
		try {
		postService.update(String.valueOf(toEdit.getId()), updatedPost);
		
		} catch(Exception e) {
			System.out.println("Err: " + e.getMessage());
		}
		return ("chooseEditCreatePosts.xhtml?faces-redirect=true");
	}
}
