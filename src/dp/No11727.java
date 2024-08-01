package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11727 {

    static Integer[] dp = new Integer[1001]; // (1 ≤ n ≤ 1,000)
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(cal(n));

    }

    static int cal(int n) {
        if(n == 1) return 1;
        if(n == 2) return 3;
        if(dp[n] != null) return dp[n];

        return dp[n] = (cal(n-1) + 2 * cal(n-2)) % 10007;
    }
}