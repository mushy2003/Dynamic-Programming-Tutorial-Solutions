package Memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllConstructMemo {

  static Map<String, List<List<String>>> memo = new HashMap<>();

  static List<List<String>> allConstruct(String target, String[] wordBank) {
    List<List<String>> res = new ArrayList<>();

    if (target.isEmpty()) {
      res.add(new ArrayList<>());
      return res;
    }

    if (memo.containsKey(target)) {
      return memo.get(target);
    }

    for (String word : wordBank) {
      if (target.startsWith(word)) {
        List<List<String>> subRes = allConstruct(target.substring(word.length()), wordBank);

        // Performing a deep copy of the list we get from the memo
        List<List<String>> copySubRes = new ArrayList<>(subRes);
        for (int i = 0; i < copySubRes.size(); i++) {
          List<String> copyList = new ArrayList<>(copySubRes.get(i));
          copyList.add(0, word);
          copySubRes.remove(i);
          copySubRes.add(i, copyList);
        }

        res.addAll(copySubRes);
      }
    }

    memo.put(target, res);
    return res;

  }

  public static void main(String[] args) {
    //System.out.println(allConstruct("purple", new String[] {"purp", "p", "ur", "le", "purpl"}));
    System.out.println(allConstruct("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd", "ef", "c"}));
  }
}
