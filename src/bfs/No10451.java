package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No10451 {

    /*
        문제 10451 순열 사이클
        순열이란 1부터 N까지의 수를 한 번씩 섞어놓은 배열

        1부터 N까지의 정수 N개로 이루어진 순열을 나타내는 방법은 여러가지가 있다
        예를 들어 8개의 수로 이루어진 순열 (3, 2, 7, 8, 1, 4, 5, 6)을 배열을 이용해 표현하면
        1 2 3 4 5 6 7 8
        3 2 7 8 1 4 5 6
        또는 방향 그래프로 나타낼 수 있다

        순열을 배열을 이용해 (1..i..n) (π1 .. πi.. πn)로 나타냈다면
        i에서 πi로 간선을 이어 그래프를 만들 수 있다

        방향그래프처럼 순열 그래프 (3, 2, 7, 8, 1, 4, 5, 6)에는 총 3개의 사이클이 있다
        순열 사이클이라 한다
        1->3->7->5->1
        2
        4->8->6->4

        N개의 정수로 이루어진 순열이 주어졌을 때 순열 사이클의 개수를 구하는 방법은

        입력
        테스트케이스 개수 T
        첫째줄에는 순열의 크기 N ( 2 <= N <= 1000)
        둘째줄에는 순열, 공백으로 구분


     */
        static ArrayList<Integer> graph;
        static boolean[] visited;
        static int cycleCount;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int testCase = Integer.parseInt(br.readLine());

            for (int r = 0; r < testCase; r++) {

                int arrSize = Integer.parseInt(br.readLine());

                //초기화
                graph = new ArrayList<>();
                graph.add(0);
                visited = new boolean[arrSize + 1];
                cycleCount = 0;

                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < arrSize; i++) {
                   graph.add(Integer.parseInt(st.nextToken()));
                }
                for (int i = 1; i <= arrSize; i++) {
                    // 방문하지 않은 숫자의 경우 다시 탐색
                    if(!visited[i]) bfs(i);
                }
                System.out.println(cycleCount);
            }
        }

        static void bfs(int start){

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            visited[start] = true;

            while (!queue.isEmpty()) {
                int current = queue.poll(); // 큐의 값
                int next = graph.get(current);

                if(!visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                }else{
                    cycleCount++;
                    break;
                }


            }
        }

        static void dfs(int start) {
            visited[start] = true;
            int next = graph.get(start);
            if(!visited[next]){
                dfs(next);
            }
        }
    }

