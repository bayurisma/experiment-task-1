package program;
public class MergesAndRuns {
  
  /** turns on the counting of merge costs */
	public static final boolean COUNT_MERGE_COSTS = true;
	/** total merge costs of all merge calls */
	public static long totalMergeCosts = 0;

  public static void mergeRuns(int[] A, int l, int m, int r, int[] B) {
		--m;// mismatch in convention with Sedgewick
		int i, j;
		assert B.length >= r+1;
		if (COUNT_MERGE_COSTS) totalMergeCosts += (r-l+1);
		for (i = m+1; i > l; --i) B[i-1] = A[i-1];
		for (j = m; j < r; ++j) B[r+m-j] = A[j+1];
		for (int k = l; k <= r; ++k)
			A[k] = B[j] < B[i] ? B[j--] : B[i++];
	}

  public static void reverseRange(int[] a, int lo, int hi) {
		while (lo < hi) {
			int t = a[lo]; a[lo++] = a[hi]; a[hi--] = t;
		}
	}


	public static int extendWeaklyIncreasingRunLeft(final int[] A, int i, final int left) {
		while (i > left && A[i-1] <= A[i]) --i;
		return i;
	}

	public static int extendWeaklyIncreasingRunRight(final int[] A, int i, final int right) {
		while (i < right && A[i+1] >= A[i]) ++i;
		return i;
	}

	public static int extendStrictlyDecreasingRunLeft(final int[] A, int i, final int left) {
		while (i > left && A[i-1] > A[i]) --i;
		return i;
	}

	public static int extendStrictlyDecreasingRunRight(final int[] A, int i, final int right) {
		while (i < right && A[i+1] < A[i]) ++i;
		return i;
	}
}
