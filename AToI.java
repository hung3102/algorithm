class AToI {
  public static void main(String args[]) {
    AToI solution = new AToI();
    System.out.println(solution.myAtoi("42") == 42);
    System.out.println(solution.myAtoi("   -42") == -42);
    System.out.println(solution.myAtoi("   -42-42") == -42);
    System.out.println(solution.myAtoi("+1") == 1);
    System.out.println(solution.myAtoi("+-2") == 0);
    System.out.println(solution.myAtoi("   +0 123") == 0);
    System.out.println(solution.myAtoi("   +42-42") == 42);
    System.out.println(solution.myAtoi("0-1") == 0);
    System.out.println(solution.myAtoi("4193 with words") == 4193);
    System.out.println(solution.myAtoi("words and 987") == 0);
    System.out.println(solution.myAtoi("-91283472332") == -2147483648);
    System.out.println(solution.myAtoi("2147483646") == 2147483646);
    System.out.println(solution.myAtoi("2147483648") == 2147483647);
  }

  public int myAtoi(String S) {
    int x = 0;
    boolean isMinus = false, startConvert = false;

    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      if ( c < '0' || c > '9') {
        if (startConvert || x != 0) return isMinus ? -x : x;

        if (c == '-') {
          isMinus = true;
          startConvert = true;
          continue;
        }
        
        if (c == '+') {
          startConvert = true;
          continue;
        }
        
        if (c == ' ') {
          continue;
        }

        return isMinus ? -x : x;
      }

      if (x > Integer.MAX_VALUE / 10 || ( x == Integer.MAX_VALUE / 10 && Character.getNumericValue(c) > 7)) {
        return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }

      startConvert = true;
      x = x * 10 + Character.getNumericValue(c);
    }

    return isMinus ? -x : x;
  }
}