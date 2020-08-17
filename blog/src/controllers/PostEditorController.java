package controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import beans.Post;
import beans.User;
import business.PostBusinessInterface;
import business.UserAuthenticationService;

/**
 * 
 * Managed bean for editing a single post.
 *
 */
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
	
	/**
	 * Initializing method for post editing.
	 */
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
	    } else {
	    	// Initialize to avoid "null" EL value errors
		    toEdit = new Post();
		    author = new User();
	    }
	}
	
	/**
	 * Updates an existing post
	 * @param updatedPost
	 * @return A string designating a return xhtml page
	 */
	public String onEdit(Post updatedPost) {
		System.out.println("Updated post item: " + updatedPost.toString());
		// set the author information from session map
		FacesContext fc = FacesContext.getCurrentInstance();
		User sessionUser = (User) fc.getExternalContext().getSessionMap().get("sessionUser");
		if(sessionUser == null || sessionUser.getEmail() == null) {
			System.out.println("Auth session is unset!!!!");
			fc.addMessage("editPostForm:titleOfPost", new FacesMessage("Please log in before editing any posts!"));
			return ""; // stay on page
		}
		
		String authorId = sessionUser.getEmail();
		if(authorId != null) updatedPost.setAuthorId(authorId);
		
		postService.update(String.valueOf(updatedPost.getId()), updatedPost);
		
		return ("chooseEditCreatePosts.xhtml?faces-redirect=true");
	}
	
	/** 
	 * Method for handling deletion of posts.
	 * @param deletedPost post to be deleted.
	 * @return String redirect string for page after deletion.
	 */
	public String onDelete(Post deletedPost) {
		
		System.out.println("Deleted post item: " + deletedPost.toString());
		
		// set the author information from session map
		FacesContext fc = FacesContext.getCurrentInstance();
		User sessionUser = (User) fc.getExternalContext().getSessionMap().get("sessionUser");
		if(sessionUser == null || sessionUser.getEmail() == null) {
			System.out.println("Auth session is unset!!!!");
			fc.addMessage("editPostForm:titleOfPost", new FacesMessage("Please log in before editing any posts!"));
			return ""; // stay on page
		}
		
		String authorId = sessionUser.getEmail();
		if(authorId != null) deletedPost.setAuthorId(authorId);
		
		postService.deletePost(String.valueOf(deletedPost.getId()), deletedPost);
		
		return ("chooseEditCreatePosts.xhtml?faces-redirect=true");
	}
}
