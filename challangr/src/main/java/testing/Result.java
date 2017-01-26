package testing;

/**
 * Created by tamara on 26/01/2017.
 */
public class Result {

  private int testsPassed;

  private int testsFailed;

  private boolean passedOverall;

  public Result(int testsPassed, int testsFailed) {
    this.testsPassed = testsPassed;
    this.testsFailed = testsFailed;
    this.passedOverall = testsPassed == testsFailed;
  }
}
