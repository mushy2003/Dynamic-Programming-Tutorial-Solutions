package Tabulation;

import java.util.ArrayList;
import java.util.List;

public class AllConstructTab {

  public static List<List<String>> allConstruct(String target, String[] wordBank) {
    final List<List<String>>[] table = (List<List<String>>[]) new List[target.length() + 1];
    for (int i = 0; i <= target.length(); i++) {
      table[i] = new ArrayList<>();
    }
    table[0].add(new ArrayList<>());

    for (int i = 0; i <= target.length(); i++) {
      if (table[i].isEmpty()) {
        continue;
      }

      for (String word : wordBank) {
        if (i + word.length() > target.length()) {
          continue;
        }

        if (target.substring(i, i + word.length()).equals(word)) {
          // Have to do a deep copy
          List<List<String>> copied = new ArrayList<>();
          for (List<String> list : table[i]) {
            List<String> subCopy = new ArrayList<>(list);
            subCopy.add(word);
            copied.add(subCopy);
          }

          table[i + word.length()].addAll(copied);
        }
      }

    }

    return table[target.length()];
  }

  public static void main(String[] args) {
    System.out.println(allConstruct("purple", new String[] {"purp", "p", "ur", "le", "purpl"}));
    System.out.println(allConstruct("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd", "ef", "c"}));
    System.out.println(allConstruct("skateboard", new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
    System.out.println(allConstruct("aaaaaaaaaaaaaz", new String[] {"a", "aa", "aaa", "aaaa", "aaaaa"}));
  }
}
