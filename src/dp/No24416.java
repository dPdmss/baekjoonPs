package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No24416 {

    static int[] f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        f = new int[n+1];
        System.out.print(fib(n)+" "+fibonacci(n));


    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;  // 코드1
        } else {
            return (fib(n - 1) + fib(n - 2));
        }
    }
    /*
    fibonacci(n) {
        f[1] <- f[2] <- 1;
        for i <- 3 to n
            f[i] <- f[i - 1] + f[i - 2];  # 코드2
        return f[n];
    }

     */
    static int fibonacci(int n) {
        int count = 0;
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];  // 코드2
            count++;
        }
        return count;
    }

}
