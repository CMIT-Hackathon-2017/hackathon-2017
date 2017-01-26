import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by tamara on 26/01/2017.
 */

@Entity
@Table(name = "USERS")
public class User {

  private Integer id;

  private String name;

  private String email;

}
