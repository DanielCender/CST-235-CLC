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
//import services.CookieServiceInterface;

@ManagedBean
@ViewScoped
public class PostEditorController  implements Serializable {
	private static final long serialVersionUID = 1L;
	
//	@Inject 
//	private CookieServiceInterface cookieService;
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
		// Get post updater
//		String authorId = cookieService.getCookie("currentUser").getValue();
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
}
