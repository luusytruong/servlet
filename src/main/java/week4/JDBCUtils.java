package week4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
//    private String url = "jdbc:mysql://localhost:3306/test";
	private String url = "jdbc:mysql://localhost:3306/isea";
	private String user = "root";
	private String password = "";

	private static JDBCUtils instance;

	private JDBCUtils() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static synchronized JDBCUtils getInstance() {
		if (instance == null) {
			instance = new JDBCUtils();
		}
		return instance;
	}

	public Connection getConn() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public void closeConn(Connection conn, ResultSet rs, Statement stmt, PreparedStatement pstmt) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
