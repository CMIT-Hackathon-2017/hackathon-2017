/**
 * Created by tamara on 26/01/2017.
 */
public class Reply {

  private int id;

  private int userId;

  private int challengeId;

  private ProgrammingLanguage programmingLanguage;

  private String reply;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getChallengeId() {
    return challengeId;
  }

  public void setChallengeId(int challengeId) {
    this.challengeId = challengeId;
  }

  public ProgrammingLanguage getProgrammingLanguage() {
    return programmingLanguage;
  }

  public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
    this.programmingLanguage = programmingLanguage;
  }

  public String getReply() {
    return reply;
  }

  public void setReply(String reply) {
    this.reply = reply;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  private int score;
}
