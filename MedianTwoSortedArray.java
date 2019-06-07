class MedianTwoSortedArray {
  public static void main(String args[]) {
    MedianTwoSortedArray solution = new MedianTwoSortedArray();
    int[] a = new int[1000], b = new int[1000];
    a = new int[]{0, 0, 0};
    b = new int[]{0, 0, 0};
    System.out.println (solution.findMedianSortedArrays(a, b) == 0.0);
    a = new int[]{0};
    b = new int[]{0, 0};
    System.out.println (solution.findMedianSortedArrays(a, b) == 0.0);
    a = new int[]{1, 3};
    b = new int[]{2};
    System.out.println (solution.findMedianSortedArrays(a, b) == 2.0);
    a = new int[]{1, 2};
    b = new int[]{3, 4};
    System.out.println (solution.findMedianSortedArrays(a, b) == 2.5);
    a = new int[]{1, 3, 5, 28, 34};
    b = new int[]{0, 4, 8, 32, 43, 78};
    System.out.println (solution.findMedianSortedArrays(a, b) == 8.0);
    a = new int[]{1, 2};
    b = new int[]{-1, 3};
    System.out.println (solution.findMedianSortedArrays(a, b) == 1.5);
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m, n;
    int[] A, B;

    if (nums1.length <= nums2.length) {
      m = nums1.length;
      n = nums2.length;
      A = nums1;
      B = nums2;
    }
    else {
      m = nums2.length;
      n = nums1.length;
      A = nums2;
      B = nums1;
    }

    int iMin = 0, iMax = m;
    int i, j;
    while (iMin <= iMax) {
      i = (iMin + iMax) / 2;
      j = (m + n + 1) / 2 - i;
      if (i > iMin && A[i-1] > B[j]) {
        iMax = i - 1;
      } else if (i < iMax && A[i] < B[j-1]) {
        iMin = i + 1;
      } else {
        if ((m + n) % 2 == 1) {
          if (i == 0) return (double) B[j-1];
          if (j == 0) return (double) A[i-1];
          return A[i-1] < B[j-1] ? (double) B[j-1] : (double) A[i-1];
        } else {
          int leftMax, rightMin;
          if (i == 0) leftMax = B[j-1];
          else if (j == 0) leftMax = A[i-1];
          else leftMax = A[i-1] < B[j-1] ? B[j-1] : A[i-1];

          if (i == m) rightMin = B[j];
          else if (j == n) rightMin = A[i];
          else rightMin = A[i] < B[j] ? A[i]: B[j];

          return (double) (leftMax + rightMin) / 2;
        }
      }
    }

    return 0.0;
  }
}