class RegularExpressionMatch {
  public static void main(String args[]) {
    RegularExpressionMatch solution = new RegularExpressionMatch();
    System.out.println(solution.isMatch("", "") == true);
    System.out.println(solution.isMatch("", "a") == false);
    System.out.println(solution.isMatch("aa", "") == false);
    System.out.println(solution.isMatch("aa", "a") == false);
    System.out.println(solution.isMatch("aa", "aa") == true);
    System.out.println(solution.isMatch("aa", "a*") == true);
    System.out.println(solution.isMatch("ab", ".*") == true);
    System.out.println(solution.isMatch("bab", ".*") == true);
    System.out.println(solution.isMatch("aab", "c*a*b") == true);
    System.out.println(solution.isMatch("mississippi", "mis*is*p*.") == false);
    System.out.println(solution.isMatch("mississippi", "mis*is*ip*.") == true);
    System.out.println(solution.isMatch("aaa", "a.a") == true);
    System.out.println(solution.isMatch("aaa", "aaaa") == false);
    System.out.println(solution.isMatch("aaa", "aaa*") == true);
    System.out.println(solution.isMatch("ab", ".*c") == false);
    System.out.println(solution.isMatch("aaa", "a*a") == true);
    System.out.println(solution.isMatch("aaa", "a*aa") == true);
    System.out.println(solution.isMatch("aaa", "a*aaa") == true);
    System.out.println(solution.isMatch("aaabbb", "a*aab*b") == true);
    System.out.println(solution.isMatch("aaabbb", "b*a*aab*b") == true);
    System.out.println(solution.isMatch("a", "ab*") == true);
    System.out.println(solution.isMatch("a", "ab*a") == false);
    System.out.println(solution.isMatch("ab", ".*..") == true);
    System.out.println(solution.isMatch("", ".*") == true);
    System.out.println(solution.isMatch("abcdede", "ab.*de") == true);
    System.out.println(solution.isMatch("bab", "..*") == true);
    System.out.println(solution.isMatch("aab", "b.*") == false);
  }

  public boolean isMatch(String s, String p) {
    if (s.equals("")) return isMatchNothing(p, 0);
    if (p.equals("")) return false;

    return checkMatch(s, p, 0, 0);
  }

  private boolean checkMatch(String s, String p, int startS, int startP) {
    int i = startP, j = startS, nextJ;
    char sc, pc;

    while (i < p.length()) {
      boolean isMatchNothing = isMatchNothing(p, i);
      if (isMatchNothing) return true;

      pc = p.charAt(i);
      sc = s.charAt(j);
      switch(pc) {
        case '.':
          i++;
          if (i >= p.length()) return j == s.length() - 1;
          if (p.charAt(i) != '*') {
            j++;
            continue;
          }

          nextJ = getNextDiffChar(j, sc, s);
          i++;
          for (int k = j; k < s.length(); k++) {
            boolean match = checkMatch(s, p, k, i);
            if (match) return true;
          }

          j = nextJ;
          continue;

        case '*':
          i++;
          continue;

        default: // [a-z]
          if (pc == sc) {
            i++;
            if (i >= p.length()) return j == s.length() - 1;
            if (p.charAt(i) != '*') {
              j++;
              continue;
            }

            nextJ = getNextDiffChar(j, sc, s);
            i++;
            for (int k = j; k < nextJ; k++) {
              boolean match = checkMatch(s, p, k, i);
              if (match) return true;
            }

            j = nextJ;
            continue;
          }
          
          i++;
          if (i >= p.length()) return false;
          if (p.charAt(i) == '*') {
            i++;
            continue;
          }

          return false;
      }
    }

    return j > s.length() - 1 && i > p.length() - 1;
  }

  private boolean isMatchNothing(String p, int index) {
    if (p.length() == 0) return true;
    if (index == p.length() - 1) return p.charAt(index) == '*';
    if (p.charAt(p.length() - 1) != '*') return false;

    for (int i = index; i < p.length() - 1; i = i + 2) {
      if (p.charAt(i) != '*' && p.charAt(i + 1) != '*') return false;
    }

    return true;
  }

  private int getNextDiffChar(int j, char sc, String s) {
    j++;

    while (j < s.length() && s.charAt(j) == sc) {
      j++;
    }

    return j;
  }
}