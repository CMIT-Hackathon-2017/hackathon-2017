package testing;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int[] twoSum(int[] numbers, int target) {
    Map<Integer, Integer> valueIndex = new HashMap();
    for(int i=0; i<numbers.length; i++) {
      if(valueIndex.containsKey(target-numbers[i])) {
        return new int[]{valueIndex.get(target-numbers[i]), i};
      }
      valueIndex.put(numbers[i], i);
    }
    return new int[]{-1,-1};
  }
}
