import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/jdbc", "postgres", "josecarlos");
		return connection;
	}
}
