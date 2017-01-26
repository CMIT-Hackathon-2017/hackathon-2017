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
    PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    preparedStatement.setString(1, user.getName());
    preparedStatement.setString(2, user.getEmail());
    int result = 0;
    if (preparedStatement.executeUpdate() == 1) {
      ResultSet rs = preparedStatement.getGeneratedKeys();
      rs.next();
      result = rs.getInt("ID");
    }

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

  public static int insertIntoEvents(Event event) throws SQLException {
    String sql = "INSERT INTO event (TITLE, DESCRIPTION, PASSWORD) VALUES (?, ?, ?)";
    PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    preparedStatement.setString(1, event.getTitle());
    preparedStatement.setString(2, event.getDescription());
    preparedStatement.setString(3, event.getPassword());
    int result = 0;
    if (preparedStatement.executeUpdate() == 1) {
      ResultSet rs = preparedStatement.getGeneratedKeys();
      rs.next();
      result = rs.getInt("ID");
    }

    System.out.println("Event created with id: " + result);
    return result;
  }

  public static Event selectFromEvents(int eventId) throws SQLException {
    String sql = "SELECT * FROM event WHERE id = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setInt(1, eventId);
    ResultSet rs = preparedStatement.executeQuery();
    if (rs.next()) {
      Event event = new Event(rs.getString("TITLE"), rs.getString("DESCRIPTION"), rs.getString("PASSWORD"));
      return event;
    } else {
      return null;
    }
  }

  public static int insertIntoChallenges(Challenge challenge) throws SQLException {
    String sql = "INSERT INTO challenge (TITLE, DESCRIPTION, SAMPLE, DIFFICULTY_ID) VALUES (?, ?, ?, ?)";
    PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    preparedStatement.setString(1, challenge.getTitle());
    preparedStatement.setString(2, challenge.getDescription());
    preparedStatement.setString(3, challenge.getSample());
    preparedStatement.setInt(4, challenge.getDifficultyId());
    int result = 0;
    if (preparedStatement.executeUpdate() == 1) {
      ResultSet rs = preparedStatement.getGeneratedKeys();
      rs.next();
      result = rs.getInt("ID");
    }

    System.out.println("Challenge created with id: " + result);
    return result;
  }

  public static Challenge selectFromChallenges(int challengeId) throws SQLException {
    String sql = "SELECT * FROM challenge WHERE id = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setInt(1, challengeId);
    ResultSet rs = preparedStatement.executeQuery();
    if (rs.next()) {
      Challenge challenge = new Challenge(rs.getString("TITLE"), rs.getString("DESCRIPTION"), rs.getString("SAMPLE"), rs.getInt("DIFFICULTY_ID"));
      return challenge;
    } else {
      return null;
    }
  }

  public static int insertIntoChallenges(Challenge challenge) throws SQLException {
    String sql = "INSERT INTO challenge (TITLE, DESCRIPTION, SAMPLE, DIFFICULTY_ID) VALUES (?, ?, ?, ?)";
    PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    preparedStatement.setString(1, challenge.getTitle());
    preparedStatement.setString(2, challenge.getDescription());
    preparedStatement.setString(3, challenge.getSample());
    preparedStatement.setInt(4, challenge.getDifficultyId());
    int result = 0;
    if (preparedStatement.executeUpdate() == 1) {
      ResultSet rs = preparedStatement.getGeneratedKeys();
      rs.next();
      result = rs.getInt("ID");
    }

    System.out.println("Challenge created with id: " + result);
    return result;
  }

  public static Reply selectFromChallenges(int replyId) throws SQLException {
    String sql = "SELECT * FROM challenge WHERE id = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setInt(1, challengeId);
    ResultSet rs = preparedStatement.executeQuery();
    if (rs.next()) {
      Challenge challenge = new Challenge(rs.getString("TITLE"), rs.getString("DESCRIPTION"), rs.getString("SAMPLE"), rs.getInt("DIFFICULTY_ID"));
      return challenge;
    } else {
      return null;
    }
  }


}
