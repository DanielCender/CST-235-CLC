package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.hibernate.validator.constraints.NotBlank;

@ManagedBean(name="post")
@ViewScoped
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String id;
	
	@NotBlank(message="Post title cannot be empty!")
	String postTitle;
	
	@NotBlank(message="Post content cannot be empty!")
	String postContent;
	
	@NotBlank(message="Author's ID cannot be empty!")
	String authorId;
	
	
	public Post() {
		this.id = "";
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
		this.id = "";
		this.authorId = authorId;
		this.postTitle = postTitle;
		this.postContent = postContent;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
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
}
