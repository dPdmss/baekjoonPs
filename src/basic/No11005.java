package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11005 {
    public static void main(String[] args) throws IOException {

        // 60466175 36
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        StringBuilder result = new StringBuilder();
        while(n != 0) {
            int remainder = n % b;
            if(remainder >= 0  & remainder < 10) {
                result.insert(0, (char)(remainder+'0'));
            }else {
                result.insert(0, (char) (remainder - 10 +'A'));
            }
            n /= b;
        }
        System.out.println(result);
    }
}
