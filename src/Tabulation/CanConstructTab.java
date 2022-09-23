package Tabulation;

public class CanConstructTab {

  public static boolean canConstruct(String target, String[] wordBank) {
    final boolean[] table = new boolean[target.length() + 1];
    table[0] = true;

    for (int i = 0; i <= target.length(); i++) {
      if (!table[i]) {
        continue;
      }

      for (String word : wordBank) {
        if (word.length() > target.length() - i) {
          continue;
        }

        if (target.substring(i, i + word.length()).equals(word)) {
          table[i + word.length()] = true;
          if (i + word.length() == target.length()) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
    System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
    System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
    System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[] {
            "e",
            "ee",
            "eee",
            "eeee",
            "eeeee",
            "eeeeee"
    }));
  }
}
