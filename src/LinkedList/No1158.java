package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No1158 {
    /*
        문제 1158 요세푸스

        1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고
        양의 정수 K(<=N)가 주어진다
        순서대로 k번째 사람을 제거한다
        N명의 사람이 모두 제거될 때까지 반복한다

        (N,K)-요세푸스 순열이라고 한다

        예를 들어 (7,3) 순열은 <3,6,2,7,5,1,4>이다

        (1 <= K <= N <= 5000)

        ** 시간복잡도 계산
        입력의 상한값 5_000으로 N^2 까지 가능


     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken()); // 리스트 사이즈
        int k = Integer.parseInt(tokenizer.nextToken())-1; // K

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;

        while (!list.isEmpty()){
            index = (index + k) % list.size();
            result.add(list.remove(index));
        }

        StringBuffer sb = new StringBuffer();
        sb.append("<");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));

            if (i != result.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}