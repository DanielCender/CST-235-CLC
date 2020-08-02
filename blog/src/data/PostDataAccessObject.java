package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import beans.Post;

@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class PostDataAccessObject implements PostDataAccessInterface<Post> {

	@Inject 
	private Post post;
	
	//Gets a single article by its ID
	@Override
	public Post get(String id) {
		Connection conn = DataAccessInterface.getConnection();
		post = new Post();
		
		try {
			String query = "SELECT * FROM GCU.Posts WHERE ID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			 
			while(rs.next()) {
				post.setPostTitle(rs.getString("title"));
				post.setPostContent(rs.getString("content"));
				post.setAuthorId("authorid");
				
				System.out.println("Post: " + post.toString());
			}
			
			rs.close();
			ps.close();
			
			System.out.println("Finished finding post by id!");
		}
		catch(SQLException ex) {
			System.out.println("Error trying to get post by id: " + ex.getMessage());
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("Connection Closed!");
				}
				catch(SQLException ex) {
					System.out.println("Problem Closing Connection!");
				}
			}
		}
		
		return new Post(post);
	}

	@Override
	public List<Post> getAll() {
		Connection conn = DataAccessInterface.getConnection();
		List<Post> postList = new ArrayList<Post>();
		
		try {
			String query = "SELECT * FROM GCU.Posts";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				post.setPostTitle(rs.getString("title"));
				post.setPostContent(rs.getString("content"));
				post.setAuthorId("authorid");
				postList.add(new Post(post));
			}
			
			rs.close();
			statement.close();
			
			System.out.println("Finished generating post list!");
		}
		catch(SQLException ex) {
			System.out.println("Error trying to get post list: " + ex.getMessage());
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("Connection Closed!");
				}
				catch(SQLException ex) {
					System.out.println("Problem Closing Connection!");
				}
			}
		}
		
		return postList;
	}

	//Saves a single post to the database
	@Override
	public void save(Post t) {
		Connection conn = DataAccessInterface.getConnection();
		try {
			String query = "INSERT INTO GCU.Posts (title, content, authorId) VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getPostTitle());
			ps.setString(2, t.getPostContent());
			ps.setString(3, t.getAuthorId());
			
			int rows = ps.executeUpdate();
			if(rows < 1) {
				System.out.println("Could not register post!");
			}
			else {
				System.out.println("Registered post!");
			}
			
			ps.close();
		}
		catch(SQLException ex) {
			System.out.println("Could not add new post: " + ex.getMessage());
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("Connection Closed!");
				}
				catch(SQLException ex) {
					System.out.println("Problem Closing Connection!");
				}
			}
		}
	}

	//updates a posts with the given ID to the new information in t
	@Override
	public void update(String id, Post t) {
		Connection conn = DataAccessInterface.getConnection();
		try {
			String query = "UPDATE GCU.Posts SET title=?, content=?, authorid=? WHERE ID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getPostTitle());
			ps.setString(2, t.getPostContent());
			ps.setString(3, t.getPostContent());
			ps.setString(4, id);
			
			int rows = ps.executeUpdate();
			if(rows < 1) {
				System.out.println("Could not update post!");
			}
			else {
				System.out.println("Updated post!");
			}
			
			ps.close();
		}
		catch(SQLException ex) {
			System.out.println("Could not update post: " + ex.getMessage());
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("Connection Closed!");
				}
				catch(SQLException ex) {
					System.out.println("Problem Closing Connection!");
				}
			}
		}
	}

	//deletes a single user with the given email
	@Override
	public void delete(Post t) {
		Connection conn = DataAccessInterface.getConnection();
		try {
			String query = "DELETE FROM GCU.Posts WHERE ID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getId());
			
			int rows = ps.executeUpdate();
			if(rows < 1) {
				System.out.println("Could not delete post!");
			}
			else {
				System.out.println("Post Deleted!");
			}
			
			ps.close();
		}
		catch(SQLException ex) {
			System.out.println("Could not delete post: " + ex.getMessage());
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("Connection Closed!");
				}
				catch(SQLException ex) {
					System.out.println("Problem Closing Connection!");
				}
			}
		}
	}
}