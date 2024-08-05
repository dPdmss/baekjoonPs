package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2579 {
    /*
    계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
    연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
    마지막 도착 계단은 반드시 밟아야 한다.

    한칸오르고 n번째칸 선택 -> 마지막칸 전에는 불가능
    한칸 건너뛰고 n번째칸 선택
    n-1번째 칸 선택
     */

    static int[] org;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        org = new int[n + 1];
        dp = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            org[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        System.out.println(solve(n));
    }

    static int solve(int n) {
        if (n <= 0) {
            return 0;
        }

        if (dp[n] == null) {
            dp[n] = Math.max(solve(n - 3) + org[n - 1], solve(n - 2)) + org[n];
        }

        return dp[n];
    }
}
