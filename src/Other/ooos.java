package Other;

import java.util.Scanner;

public class ooos {
    public static int[] maxSum(int[] arr) {
        int[] res = new int[3];
        int[] maxsum = new int[arr.length];
        int max = arr[0], start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                if ((maxsum[i - 1] + arr[i]) >= arr[i]) {
                    maxsum[i] = maxsum[i - 1] + arr[i];
                } else {
                    maxsum[i] = arr[i];
                    start = i;
                }
            } else {
                maxsum[i] = arr[i];
                start = i;
                max = maxsum[i];
                res[0] = max;
                res[1] = start;
                res[2] = i;
            }
            if (maxsum[i] > max) {
                max = maxsum[i];
                res[0] = max;
                res[1] = start;
                res[2] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, total, num;
        int[][] arr = null;
        while (sc.hasNext()) {
            T = sc.nextInt();
            if (T >= 1 && T <= 20) {
                arr = new int[T][];
                for (int i = 0; i < T; i++) {
                    total = sc.nextInt();
                    arr[i] = new int[total];
                    for (int j = 0; j < total; j++) {
                        num = sc.nextInt();
                        arr[i][j] = num;
                    }
                    System.out.println("Case " + (i + 1) + ":");
                    int[] max = maxSum(arr[i]);
                    System.out.println(max[0] + " " + (max[1] + 1) + " "
                            + (max[2] + 1));
                    if (i != T - 1) {
                        System.out.println();
                    }
                }
            }
        }
    }
}