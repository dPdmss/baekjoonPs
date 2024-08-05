package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;

public class No2156 {
    /*
    포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
    연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
    -> 비연속적 선택

        n번째 값을 선택한 경우 경우의 수
            -> dp[n-3] + n-1 + n
            -> dp[n-2] + n
        n번째 값을 선택하지 않았을 때
            -> dp[n-1]

        dp[n-1]의 값이 n번째 값을 더한 값보다 큰 경우 dp[n-1]의 값을 저장
     */

    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 포도주의 잔의 개수 받기
        int length = Integer.parseInt(br.readLine());

        arr = new int[length + 1];
        dp = new Integer[length + 1];

        dp[0] = 0;

        // 잔의 개수 만큼 잔마다의 포도주의 양 입력 받기
        for (int i = 1; i <= length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        System.out.println(solve(length));
    }

    static int solve(int n) {

        if(n <= 0) return 0;
        if(n == 1) return dp[n] = arr[1];

        // < N-3까지의 최대값 + N-1의 값 > || < N-2까지의 최대값 > 중에 큰 값 + N
        // N-1까지의 최대값이 N을 더한 값보다 크면 N-1의 값을 DP 배열에 저장
        if (dp[n] == null) {
            dp[n] = Math.max(Math.max(solve(n-2), solve(n-3) + arr[n - 1]) + arr[n], solve(n-1));
        }

        return dp[n];
    }

}
