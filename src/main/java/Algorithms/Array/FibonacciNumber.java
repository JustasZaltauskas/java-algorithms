package Algorithms.Array;

public class FibonacciNumber {
    public static int fib(int N) {
        if (N == 0) return 0;

        int[] arr = new int[2];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2 ; i <= N ; i++) {
            int x = arr[0] + arr[1];
            arr[0] = arr[1];
            arr[1] = x;
        }

        return arr[1];
    }

    public static int fibRecursive(int N) {
        return helper(N, new int[N + 1]);
    }

    private static int helper(int N, int[] res) {
        if (N <= 1) {
            return N;
        } else if (res[N] == 0) {
            res[N] = helper(N - 1, res) + helper(N - 2, res);
        }

        return res[N];
    }
}
