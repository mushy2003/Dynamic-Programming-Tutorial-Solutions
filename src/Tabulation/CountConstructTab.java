package Tabulation;

public class CountConstructTab {

  public static int countConstruct(String target, String[] wordBank) {
    final int[] table = new int[target.length() + 1];
    table[0] = 1;

    for (int i = 0; i <= target.length(); i++) {
      if (table[i] == 0) {
        continue;
      }

      for (String word : wordBank) {
        if (i + word.length() > target.length()) {
          continue;
        }

        if (target.substring(i, i + word.length()).equals(word)) {
          table[i + word.length()] += table[i];
        }
      }
    }

    return table[target.length()];
  }

  public static void main(String[] args) {
    System.out.println(countConstruct("purple", new String[] {"purp", "p", "ur", "le", "purpl"}));
    System.out.println(countConstruct("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"}));
    System.out.println(countConstruct("skateboard", new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
    System.out.println(countConstruct("enterapotentpot", new String[] {"a", "p", "ent", "enter", "ot", "o", "t"}));
    System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[] {
            "e",
            "ee",
            "eee",
            "eeee",
            "eeeee",
            "eeeeee"
    }));
  }
}
