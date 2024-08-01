package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10844 {

    final static long mod = 1000000000L;
    public static void main(String[] args) throws IOException {

        // 길이가 N인 계단 수가 총 몇개 있는지 (0으로 시작하는 수는 계단수가 아니다)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n+1][10]; // dp[자리수][앞에 오는 숫자] = 경우의 수

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1; // 1의 자리 값 1로 초기화
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i - 1][1] % mod;
                } else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n][i];
        }

        System.out.println(sum % mod);

    }
}
