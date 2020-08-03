package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.Cookie;

import beans.Post;
import business.PostBusinessInterface;
import services.CookieServiceInterface;

@ManagedBean
@ViewScoped
public class PostCreationController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CookieServiceInterface cookieService;
	
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
		FacesContext fc = FacesContext.getCurrentInstance();
		// set the author information from session cookie
		System.out.println(cookieService.toString());
		Cookie cookie = cookieService.getCookie("currentUser");
		if(cookie == null) {
			System.out.println("Auth Cookie is unset!!!!");
			fc.addMessage("newPostForm:titleOfPost", new FacesMessage("Please log in before writing any new posts!"));
			return ""; // stay on page
		}
		
		String userId = cookie.getValue();
		newPost.setAuthorId(userId);
		//add the post
		postService.addPost(newPost);
		System.out.println("Just added " + newPost.toString() + " to Posts");
		// on success go immediately to login
		return ("chooseEditCreatePosts.xhtml");
	}
}
