/**
 * Created by tamara on 26/01/2017.
 */
public class Test {

  private int id;

  private String description;

  private ProgrammingLanguage codeLanguageId;

  private String testCode;

  private int challengeId;

  public Test() {
  }

  public Test(String description, ProgrammingLanguage codeLanguageId, String testCode, int challengeId) {

    this.description = description;
    this.codeLanguageId = codeLanguageId;
    this.testCode = testCode;
    this.challengeId = challengeId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProgrammingLanguage getCodeLanguageId() {
    return codeLanguageId;
  }

  public void setCodeLanguageId(ProgrammingLanguage codeLanguageId) {
    this.codeLanguageId = codeLanguageId;
  }

  public String getTestCode() {
    return testCode;
  }

  public void setTestCode(String testCode) {
    this.testCode = testCode;
  }

  public int getChallengeId() {
    return challengeId;
  }

  public void setChallengeId(int challengeId) {
    this.challengeId = challengeId;
  }
}
