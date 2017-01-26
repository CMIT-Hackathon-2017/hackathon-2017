import java.sql.*;

/**
 * Created by tamara on 26/01/2017.
 */
public class DatabaseUtil {

  private static Connection connection;

  public static void makeConnection(String url, String username, String password) throws SQLException {
    connection = DriverManager.getConnection(url, username, password);
  }

  public static int insertIntoUsers(User user) throws SQLException {
    String sql = "INSERT INTO users (FULL_NAME, EMAIL) VALUES (?,?)";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, user.getName());
    preparedStatement.setString(2, user.getEmail());
    int result = preparedStatement.executeUpdate();
    System.out.println("User created with id: " + result);
    return result;
  }

  public static int selectFromUsers(User user) throws SQLException {
    String sql = "SELECT * FROM users WHERE email = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, user.getEmail());
    ResultSet rs = preparedStatement.executeQuery();
    if (rs.next()) {
      User newUser = user;
      newUser.setId(rs.getInt("ID"));
      newUser.setName(rs.getString("FULL_NAME"));
      return newUser.getId();
    } else {
      return insertIntoUsers(user);
    }
  }
}
