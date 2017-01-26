/**
 * Created by tamara on 26/01/2017.
 */
public class Reply {

  private int id;

  private int userId;

  private int challengeId;

  private ProgrammingLanguage codeLanguageId;

  private String reply;

  public Reply() {

  }

  public Reply(int userId, int challengeId, ProgrammingLanguage codeLanguageId, String reply, int score) {
    this.userId = userId;
    this.challengeId = challengeId;
    this.codeLanguageId = codeLanguageId;
    this.reply = reply;
    this.score = score;
  }

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

  public ProgrammingLanguage getCodeLanguageId() {
    return codeLanguageId;
  }

  public void setCodeLanguageId(ProgrammingLanguage codeLanguageId) {
    this.codeLanguageId = codeLanguageId;
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
