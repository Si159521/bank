import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/bank"; // 데이터베이스 URL
    private static final String USER = "seoyoung"; // MySQL 사용자 이름
    private static final String PASSWORD = "root"; // MySQL 비밀번호

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
