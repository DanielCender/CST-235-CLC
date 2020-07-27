package beans;

//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
//import javax.imageio.ImageIO;

import org.hibernate.validator.constraints.NotBlank;

@ManagedBean(name="post")
@ViewScoped
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank(message="Author's first name cannot be empty!")
	String authorFirstName;
	
	@NotBlank(message="Author's last name cannot be empty!")
	String authorLastName;
	
	@NotBlank(message="Post title cannot be empty!")
	String postTitle;
	
	@NotBlank(message="Post content cannot be empty!")
	String postContent;
	
//	String imagePath;
	
//	BufferedImage postImage;
	
	public Post() {
		this.authorFirstName = "";
		this.authorLastName = "";
		this.postTitle = "";
		this.postContent = "";
//		this.imagePath = "";
//		applyImagePath();
		
	}

	public Post(String authorFirstName, String authorLastName, String postTitle, String postContent) {
		
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.postTitle = postTitle;
		this.postContent = postContent;
//		this.imagePath = imagePath;
//		applyImagePath();
		
	}
	
//	private void applyImagePath() {
//		if (!this.imagePath.isEmpty()) {
//			try {
//				postImage = ImageIO.read(new File(this.imagePath));
//			} catch (IOException e) {
//				e.printStackTrace();
//				System.out.println("Unable to process selected image");
//			}
//		} else {
//			try {
//				postImage = ImageIO.read(new File("/blog/WebContent/resources/images/default.jpg"));
//			} catch (IOException e) {
//				e.printStackTrace();
//				System.out.println("Default Image Failure");
//			}
//		}
//	}
	
	

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
//
//	public String getImagePath() {
//		return imagePath;
//	}
//
//	public void setImagePath(String imagePath) {
//		this.imagePath = imagePath;
//	}
//
//	public BufferedImage getPostImage() {
//		return postImage;
//	}
//
//	public void setPostImage(BufferedImage postImage) {
//		this.postImage = postImage;
//	}

	
	
	

}
