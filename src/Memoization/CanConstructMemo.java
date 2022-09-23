package Memoization;

import java.util.HashMap;
import java.util.Map;

public class CanConstructMemo {

  static Map<String, Boolean> memo = new HashMap<>();

  static boolean canConstruct(String target, String[] wordBank) {
    if (target.isEmpty()) {
      return true;
    }

    if (memo.containsKey(target)) {
      return memo.get(target);
    }

    boolean result = false;

    for (String word : wordBank) {
      if (target.startsWith(word) && canConstruct(target.substring(word.length()), wordBank)) {
        result = true;
        memo.put(target, result);
        return result;
      }
    }

    memo.put(target, result);
    return result;
  }

  public static void main(String[] args) {
    // System.out.println(canConstruct("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"}));
    //System.out.println(
        //canConstruct("skateboard", new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
    System.out.println(
        canConstruct(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            new String[] {"e", "ee", "eee", "eeee", "eeeee", "eeeeeeeeeee"}));
  }
}
