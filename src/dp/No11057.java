package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11057 {
    /*
    오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.

    예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.

    수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.

    첫째 줄에 길이가 N인 오르막 수의 개수를 10,007로 나눈 나머지를 출력한다.

       -> 점화식 : dp[i][j] = dp[i][j-1] + dp[i-1][j]

     */

    final static int mod = 10007;
    static Long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new Long[n+1][10];

        // 1의 자리 수 값 1 초기화
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += cal(n, i);
        }
        System.out.println(result % mod);
    }

    static long cal(int digit, int lastNumber) {

        if (dp[digit][lastNumber] == null) {

            for (int i = 2; i <= digit; i++) {
                for (int j = 0; j < 10; j++) {
                    if (j == 0) {
                        dp[i][j] = 1L;
                    } else {
                        dp[i][j] = (cal(i, j - 1) + cal(i - 1, j));
                    }
                }
            }

        }
        return dp[digit][lastNumber] % mod;
    }
}