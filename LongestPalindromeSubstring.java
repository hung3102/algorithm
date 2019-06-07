class LongestPalindromeSubstring {

  public static void main(String args[]) {
    LongestPalindromeSubstring solution = new LongestPalindromeSubstring();
    System.out.println(solution.longestPalindrome("").equals(""));
    System.out.println(solution.longestPalindrome("a").equals("a"));
    System.out.println(solution.longestPalindrome("aa").equals("aa"));
    System.out.println(solution.longestPalindrome("aaa").equals("aaa"));
    System.out.println(solution.longestPalindrome("aaaa").equals("aaaa"));
    System.out.println(solution.longestPalindrome("babad").equals("bab"));
    System.out.println(solution.longestPalindrome("cbbd").equals("bb"));
    System.out.println(solution.longestPalindrome("abcddcbfg").equals("bcddcb"));
  }

  public String longestPalindrome(String S) {
    if (S.equals("")) return "";

    int start = 0, end = -1;
    int len = 0;
    for (int i = 0; i < S.length(); i++) {
      int len1 = getAround(S, i, i);
      int len2 = getAround(S, i, i+1);
      len = Math.max(len1, len2);
      if (len > end - start + 1) {
        start = i - (len-1) / 2;
        end = start + len - 1;
      }
    }

    return S.substring(start, end+1);
  }

  private int getAround(String S, int left, int right) {
    int l = left, r = right;
    while (l >= 0 && r < S.length() && S.charAt(l) == S.charAt(r)) {
      l--;
      r++;
    }

    return r - l - 1;
  }
}