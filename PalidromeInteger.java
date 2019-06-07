class PalidromeInteger {
  public static void main(String args[]) {
    PalidromeInteger solution = new PalidromeInteger();
    System.out.println(solution.isPalindrome(0) == true);
    System.out.println(solution.isPalindrome(1) == true);
    System.out.println(solution.isPalindrome(-1) == false);
    System.out.println(solution.isPalindrome(11) == true);
    System.out.println(solution.isPalindrome(-11) == false);
    System.out.println(solution.isPalindrome(121) == true);
    System.out.println(solution.isPalindrome(-121) == false);
  }
  
  public boolean isPalindrome(int x) {
    if (x < 0) return false;

    int y = 0, temp = x, rest;
    while (temp != 0) {
      rest = temp % 10;
      temp /= 10;
      y = 10 * y + rest;
    }

    return x == y;
  }
}