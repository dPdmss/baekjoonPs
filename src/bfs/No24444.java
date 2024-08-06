package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No24444 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 입력받을 2차원 배열
    static boolean[] visited; // 정점 방문 여부 배열
    static int[] result; // 결과값 배열
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tokenizer.nextToken()); // 정점의 수
        int M = Integer.parseInt(tokenizer.nextToken()); // 간선의 수
        int START = Integer.parseInt(tokenizer.nextToken()); // 시작 정점

        // 배열 초기화
        result = new int[N + 1];
        visited = new boolean[N + 1];

        // 정점의 수만큼 ArrayList 생성 (0번째 ArrayList는 편의상 생성)
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선의 수만큼 for문을 돌면서 데이터 삽입
        for (int i = 1; i <= M; i++) {

            tokenizer = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());

            // 무방향 그래프로 각 정점에 인접한 정점들을 배열에 넣어준다
            // 배열은 위에서 정점의 수만큼 생성한 ArrayList <- get
            graph.get(u).add(v); // u 인덱스 배열에 v 정점 삽입
            graph.get(v).add(u); // v 인덱스 배열에 u 정점 삽입
        }

        bfs(START);

        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>(); // linkedList로 queue 구현

        queue.offer(start);

        int count = 1;
        visited[start] = true;
        result[start] = count;

        while(!queue.isEmpty()){

            int node = queue.poll();
            List<Integer> list = graph.get(node);
            Collections.sort(list); // 오름차순 정렬
            for (Integer i : list) {
                // 인접 정점 중 방문하지 않은 정점을 탐색
                if (!visited[i]) {
                    visited[i] = true;
                    result[i] = ++count; // 방문순서 배열에 저장
                    queue.offer(i); // queue에 집어넣음
                }
            }
        }
    }
}
