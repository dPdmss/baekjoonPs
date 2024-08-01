package dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11726 {

    static Integer[] dp = new Integer[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        System.out.println(cal(x));
    }

    static int cal(int n) {
        if(n == 1) return 1;  // n이 1이면 경우의 수 1
        if(n == 2) return 2;  // n이 1이면 경우의 수 2
        if(dp[n] != null) return dp[n]; // 값이 이미 있으면 기존 기존 값 return
        return dp[n] = (cal(n-1)+cal(n-2)) % 10007;
    }
}
