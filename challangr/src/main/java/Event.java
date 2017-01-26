/**
 * Created by tamara on 26/01/2017.
 */
public class Event {

  private int id;

  private String title;

  private String description;

  private String password;

  public Event() {

  }

  public Event(String title, String description, String password) {
    this.title = title;
    this.description = description;
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
