package controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import beans.Post;
import business.PostCreationInterface;
import business.PostCreationService;

/**
 * 
 * TODO: This controller will instanstiate the PostsService (which will interact with the DAO db service)
 * - For now, this controller allows the posts to persist over different pages.
 * - It looks like this controller is doing nothing for now, but we'll need to refactor it to access the database operation services later 
 *
 */

@ManagedBean
@ViewScoped
public class PostsController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PostCreationInterface posts;
	
	// Unneeded for the moment
//	public void setPosts() {
//		this.posts = new PostCreationService();
//		this.posts.addPost(new Post("Dan", "Cender", "Some Title", "Some Content"));
//		this.posts.addPost(new Post("Marc", "T", "Some Title", "Some Content"));
//		this.posts.addPost(new Post("Chance", "Anderson", "Some Title", "Some Content"));
//		this.posts.addPost(new Post("Tim", "James", "Some Title", "Some Content"));
//	}
	
	public PostCreationInterface getPosts() {
		return posts;
	}
}
