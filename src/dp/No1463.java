package dp;
    /*
        정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

        1.X가 3으로 나누어 떨어지면, 3으로 나눈다.
        2.X가 2로 나누어 떨어지면, 2로 나눈다.
        3.1을 뺀다.
        최소 연산값 구하기
    */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1463 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {

        long start = System.nanoTime();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        dp = new Integer[x+1];
        dp[0] = dp[1] = 0;  // 값 1은 연산횟수 0

        System.out.println(recur(x));
        long end = System.nanoTime();
        System.out.println("수행시간: " + (end - start) + " ns");
    }

    static int recur(int x) {
        if (dp[x] == null) {
            if(x % 6 == 0){
                dp[x] = Math.min(recur(x - 1), Math.min(recur(x / 3), recur(x / 2))) + 1;
            }else if(x % 3 == 0) {
                dp[x] = Math.min(recur(x / 3),recur(x - 1)) + 1;
            }else if(x % 2 == 0) {
                dp[x] = Math.min(recur(x / 2),recur(x - 1)) + 1;
            }else{
                dp[x] = recur(x - 1)+1;
            }
        }
        return dp[x];
    }
}
