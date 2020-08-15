package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * Managed bean to hold information on a single post of a blog.
 *
 */
@ManagedBean(name="post")
@ViewScoped
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int id;
	
	@NotBlank(message="Post title cannot be empty!")
	String postTitle;
	
	@NotBlank(message="Post content cannot be empty!")
	String postContent;
	
	@NotBlank(message="Author's ID cannot be empty!")
	String authorId;
	
	
	public Post() {
		this.authorId = "";
		this.postTitle = "";
		this.postContent = "";
		
	}
	
	public Post(Post p) {
		this.id = p.id;
		this.authorId = p.authorId;
		this.postTitle = p.postTitle;
		this.postContent = p.postContent;
	}

	public Post(String authorId, String postTitle, String postContent) {
		this.authorId = authorId;
		this.postTitle = postTitle;
		this.postContent = postContent;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	
	@Override
	public String toString() {
		return ("Post: " + this.id + " - " + this.postTitle + " - " + this.postContent + " - " + this.authorId);
	}
}
