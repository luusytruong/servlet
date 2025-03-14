package week5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
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
	if(instance == null) {
		instance = new JDBCUtils();
	}
	return instance;
}

public Connection getConn() {
	try {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
	}
	catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
		return null;
	}
}

}
