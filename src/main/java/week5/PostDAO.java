package week5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostDAO {
	public static PostDAO instance;

	private PostDAO() {
	}

	public static synchronized PostDAO getInstance() {
		if (instance == null) {
			instance = new PostDAO();
		}
		return instance;
	}

	public ArrayList<Post> getAll(Connection conn) {
		try {
			ArrayList<Post> posts = new ArrayList<Post>();
			PreparedStatement stmt = conn.prepareStatement("select * from posts order by id desc");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Post post = new Post(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				System.out.println(post);
				posts.add(post);
			}
			rs.close();
			stmt.close();
			conn.close();

			return posts;
		} catch (SQLException e) {
			// TODO: handle exception
			return new ArrayList<Post>();
		}
	}

	public boolean insert(Post post, Connection conn) {
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("insert into posts (title, content, location) values (?,?,?)");
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getContent());
			pstmt.setString(3, post.getLocation());

			int rowAffected = pstmt.executeUpdate();

			pstmt.close();
			conn.close();

			return rowAffected > 0;
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}
	}
	public boolean update(Post post, Connection conn) {
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("update posts set title=?,content=?,location=? where id=?");
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getContent());
			pstmt.setString(3, post.getLocation());
			pstmt.setInt(4, post.getId());
			
			int rowAffected = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			return rowAffected > 0;
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}
	}
	public boolean delete(int id, Connection conn) {
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("delete from posts where id=?");
			pstmt.setInt(1, id);
			
			int rowAffected = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			return rowAffected > 0;
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}
	}
}
