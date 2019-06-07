class ReverseInteger {
  public static void main(String args[]) {
    ReverseInteger solution = new ReverseInteger();
    System.out.println(solution.reverse(0) == 0);
    System.out.println(solution.reverse(123) == 321);
    System.out.println(solution.reverse(-123) == -321);
    System.out.println(solution.reverse(-120) == -21);
    System.out.println(solution.reverse(120) == 21);
    System.out.println(solution.reverse(1534236469) == 0);
  }

  public int reverse(int x) {
    int rest, y = 0;

    while (x != 0) {
      rest = x % 10;
      if (y > Integer.MAX_VALUE/ 10 || y < Integer.MIN_VALUE / 10) return 0;
      y = 10 * y + rest;
      x /= 10;
    }

    return y;
  }
}