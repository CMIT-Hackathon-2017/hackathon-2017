import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

/**
 * Created by tamara on 26/01/2017.
 */
public class TestMain {

  public static void main(String[] args) {
    User user = new User();
    user.setName("Per");
    user.setEmail("per@email");

    try {
      DatabaseUtil.makeConnection("jdbc:postgresql://hack17pg.cscansykgw76.eu-west-1.rds.amazonaws.com:5432/hack17", "HackChal", "hackerton17");
    } catch (SQLException e) {
      e.printStackTrace();
    }

    try {
      DatabaseUtil.insertIntoUsers(user);
    } catch (SQLException e) {
      e.printStackTrace();
    }


    try {
      DatabaseUtil.selectFromUsers(user);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    System.out.println("Done");

  }
}
