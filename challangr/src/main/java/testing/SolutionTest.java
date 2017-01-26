package testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tamara on 26/01/2017.
 */
public class SolutionTest {

  static List<int[]> inputNumbers;
  static List<Integer> inputTargets;
  static List<int[]> outputResult;
  static List<Boolean> outputPass;

  static {
    inputNumbers = new ArrayList();
    inputNumbers.add(new int[]{2,7,15,17});
    inputNumbers.add(new int[]{1,2,3,4});
    inputNumbers.add(new int[]{1,2,3,4,5,6,7,8});
    inputNumbers.add(new int[]{3,4,4,3,3,4});

    inputTargets = new ArrayList();
    inputTargets.add(9);
    inputTargets.add(7);
    inputTargets.add(9);
    inputTargets.add(20);

    outputResult = new ArrayList();
    outputResult.add(new int[]{0, 1});
    outputResult.add(new int[]{2, 3});
    outputResult.add(new int[]{3, 4});
    outputResult.add(new int[]{-1, -1});



    outputPass = new ArrayList();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    for (int i=0; i<inputNumbers.size(); i++) {
      outputPass.add(evaluateSolution(outputResult.get(i), solution.twoSum(inputNumbers.get(i), inputTargets.get(i))));
    }

    long passed = outputPass.stream().filter(bool -> bool == true).count();
    System.out.println("Tests passed: " + passed + "/" + inputNumbers.size());

  }

  private static boolean evaluateSolution(int[] expected, int[] real) {
    for (int i=0; i<expected.length; i++) {
      if (expected[i] != real[i]) {
        return false;
      }
    }
    return true;
  }

}
