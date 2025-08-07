package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2331 {
    /*
        문제 2331
        D[1] = A
        D[n] = D[n-1]의 각 자리의 수를 P번 곱한 수들의 합

        예를 들어 A=57 P=2 일 때
        수열 D는 [57, 74(5^2+7^2=25+49),65, 61, 37, 58, 89, 145, 42, 20, 4, 16, 37..]
        그 뒤에는 57에 1을 더한 58부터 반복 된다

        이때 반복되는 부분을 제외했을 때 수열에 남게 되는 수들의 개수를 구하는 프로그램을 작성하시오
        위에 예시는 [57, 74, 65, 61] 네 개의 수가 남게 된다

        반복되는 부분 = 사이클의 시작
        사이클의 시작 시점 = 중복된 숫자가 처음 나오는 시점


        입력
        A(1 <= A <= 9999)
        P(1 <= P <= 5)
     */

    static Map<Integer, Integer> visited = new LinkedHashMap<>();
    static int A,P;
    static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        int result = 0;
        visited.put(A, count++);
        int next = getNext(A);
        while (true) {
            if (visited.containsKey(next)) {
                result = visited.get(next);
                break;
            }
            visited.put(next, count++);
            next = getNext(next);
        }
        System.out.println(result);
    }

    static int getNext(int num) {
        int result = 0;
        while (num > 0) {
            int digit = num % 10;
            result += Math.pow(digit, P);
            num /= 10;
        }
        return result;
    }

}
