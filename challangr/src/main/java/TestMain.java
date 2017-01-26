

import java.sql.SQLException;

/**
 * Created by tamara on 26/01/2017.
 */
public class TestMain {

  public static void main(String[] args) {
    User user = new User();
    user.setName("Per");
    user.setEmail("pers2@email");

    try {
      DatabaseUtil.makeConnection("jdbc:postgresql://hack17pg.cscansykgw76.eu-west-1.rds.amazonaws.com:5432/hack17", "HackChal", "hackerton17");
    } catch (SQLException e) {
      e.printStackTrace();
    }

    try {
      DatabaseUtil.insertIntoUsers(user);
      user.setEmail("new@email");
      DatabaseUtil.insertIntoUsers(user);
    } catch (SQLException e) {
      e.printStackTrace();
    }


    try {
      System.out.println("Selected user id: " + DatabaseUtil.selectFromUsers(user));
    } catch (SQLException e) {
      e.printStackTrace();
    }

    System.out.println("Done");

  }
}
