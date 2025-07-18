package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class No1406 {

    /*
        문제 1406 에디터

        한 줄로 된 간단한 에디터를 구현

        이 편집기에는 '커서'라는 것이 있는데,
        커서는 문장의 맨 앞(첫 번째 문자의 왼쪽),
              문장의 맨 뒤(마지막 문자의 오른쪽)
              문장 중간 임의의 곳(모든 연속된 두 문자 사이)에 위치

        커서가 위치할 수 있는 곳은 문자열 길이 L+1가지 경우
        명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치

        L	커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
        D	커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
        B	커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
            삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만,
            실제로 커서의 오른쪽에 있던 문자는 그대로임
        P $	$라는 문자를 커서 왼쪽에 추가함

        입력
        첫째줄 문자열의 길이 N
        둘째줄 명령어의 개수 정수 M < 500000
        셋째줄 M개의 줄에 걸쳐 입력할 명령어가 순서대로 주어진다

        ** 시간복잡도 계산
        -> 입력의 상한값은 500_000으로 NlogN 알고리즘 이하로 사용하기? 맞는지 여쭤보기
     */

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String initData = br.readLine(); // 초기 문자열
            int commandQty = Integer.parseInt(br.readLine()); // 명령어 개수

            LinkedList<Character> text = new LinkedList<>(); // Char 연결리스트 선언

            // 연결리스트에 초기 문자값 할당
            for (int i = 0; i < initData.length(); i++) {
                text.add(initData.charAt(i));
            }
            // ListIterator 사용하여 커서를 리스트 끝에 배치
            // 현재 위치에서 삽입 삭제를 O(1)로 매우 빠르게 처리 가능
            // 그러면 명령어 갯수만큼 for문만 돌면 되기 때문에 O(M)
            ListIterator<Character> cursor = text.listIterator(text.size());

            // 오답
            // 시간복잡도 O(M * N)
            // LinkedList 인덱스 조회 O(n)으로 명령어 갯수만큼  for문을 돌기 때문에 O(M*N)
            for (int i = 0; i < commandQty; i++) {
                String command = br.readLine();
                char cmd = command.charAt(0);

                if (cmd == 'L') {
                    // 이전 요소가 있으면 이전요소로 이동
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
                } else if (cmd == 'D') {
                    // 다음 요소가 있으면 다음요소로 이동
                    if (cursor.hasNext()) {
                        cursor.next();
                    }
                } else if (cmd == 'B') {
                    // 이전 요소가 있으면 이동 후
                    // remove next 또는 previous 메서드에 의해 반환된 가장 마지막 요소 제거
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                } else if (cmd == 'P') {
                    char input = command.charAt(2);
                    cursor.add(input);
                }
            }

            StringBuffer sb = new StringBuffer();
            for (Character c : text) {
                sb.append(c);
            }
            System.out.println(sb);
        }

    }
