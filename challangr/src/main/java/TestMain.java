

import com.nordea.hackathon2017.pojo.User;
import com.nordea.hackathon2017.utils.DatabaseUtil;

import java.sql.SQLException;

/**
 * Created by tamara on 26/01/2017.
 */
public class TestMain {

  public static void main(String[] args) {
    User user = new User();
    user.setName("Per");
    user.setEmail("pers2@email");


      DatabaseUtil.makeConnection();


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
