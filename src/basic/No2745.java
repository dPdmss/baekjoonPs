package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2745 {
    /*
    진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.

    10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.

    A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        String n = st.nextToken();  // 변화할 값 N
        int b = Integer.parseInt(st.nextToken()); // 진법 B
        int result = 0;
        int exponent = 0;
        for (int i = n.length()-1; i >= 0;  i--) {
            char chr = n.charAt(i);
            if(chr >= '0' && chr <= '9') {
                System.out.println((chr - '0') * Math.pow(b, exponent));
                result += (chr - 48) * Math.pow(b, exponent); // 숫자인 경우 '0' 의 아스키코드값 빼기
            }else {
                System.out.println((chr - 'A' + 10) * Math.pow(b, exponent));
                result += (chr - 55) * Math.pow(b, exponent); // 알파벳인 경우 65'A' - 10
            }
            System.out.println("result ->>" + result);
            exponent++;
        }

        System.out.println(result);
    }
}
