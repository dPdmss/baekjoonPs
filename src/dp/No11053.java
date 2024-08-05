package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11053 {

    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        dp = new Integer[n + 1];
        dp[0] = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        System.out.println(solve(n));
    }

    static int solve(int n){
        if (dp[n] == null) {
            dp[n] = 1;
            for (int i = n-1; i >= 0; i--) {
                if(arr[i] < arr[n]){
                    dp[n] = Math.max(dp[n], solve(i)+1);
                }
            }
        }
        return dp[n];
    }
}
