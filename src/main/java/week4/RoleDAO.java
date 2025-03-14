package week4;

import java.sql.*;
import java.util.ArrayList;

public class RoleDAO {
	private Connection conn = null;
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;

	private String sqlGetAll = "SELECT r.*, GROUP_CONCAT(u.full_name) AS users FROM roles r LEFT JOIN users u ON r.id = u.role GROUP BY r.id ORDER BY r.id ASC;";

	private static RoleDAO instance;

	public static RoleDAO getInstance() {
		if (instance == null) {
			instance = new RoleDAO();
		}
		return instance;
	}

	public String[] render(String str) {
		return str.split(",");
	}

	public ArrayList<Role> getAll(Connection _conn) {
		try {
			ArrayList<Role> students = new ArrayList<>();
			conn = _conn;
			if (conn != null) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sqlGetAll);
				while (rs.next()) {
					String[] users = rs.getString(5) != null ? render(rs.getString(5)) : new String[0];
					Role role = new Role(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), users);
					students.add(role);
				}
				return students;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtils.getInstance().closeConn(conn, rs, stmt, pstmt);
		}
	}
}
