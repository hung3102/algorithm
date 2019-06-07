class ZigzagConversion {
  public static void main(String args[]) {
    ZigzagConversion solution = new ZigzagConversion();
    System.out.println(solution.convert("", 0).equals(""));
    System.out.println(solution.convert("", 1).equals(""));
    System.out.println(solution.convert("", 2).equals(""));
    System.out.println(solution.convert("AB", 2).equals("AB"));
    System.out.println(solution.convert("PAYPALISHIRING", 1).equals("PAYPALISHIRING"));
    System.out.println(solution.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
    System.out.println(solution.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"));
  }
  
  public String convert(String S, int numRows) {
    if (S.equals("") || numRows == 1) return S;

    StringBuilder str = new StringBuilder();
    int c = 1, i = 0;
    int i1, i2, k = 0;

    while (k < S.length()) {
      if (c == 1 || c == numRows) {
        i1 = (numRows - 1) * i + (c - 1);
        if (i1 >= 0 && i1 < S.length()) {
          str.append(S.charAt(i1));
          k++;
          i = i + 2;
          continue;
        }

        i = 0;
        c++;
        continue;
      }

      i1 = (numRows - 1) * i + (c - 1);

      if (i1 < 0 || i1 >= S.length()) {
        i = 0;
        c++;
        continue;
      }

      str.append(S.charAt(i1));
      k++;
      i2 = i1 + (numRows + 1 - c) * 2 - 2;
      if (i2 < 0 || i2 >= S.length()) {
        i = 0;
        c++;
        continue;
      } 

      str.append(S.charAt(i2));
      k++;
      i = i + 2;
    }

    return str.toString();
  }
}