package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1260 {
    /*
          문제 1260 DFS와 BFS

        그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램 작성
        방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
        더 이상 방문할 수 있는 점이 없는 경우 종료한다
        정점 번호는 1번부터 N번까지

        정점의 개수 V : 1 <= V <= 1,000
        간선의 개수 E : 1 <= M <= 10,000

        시간복잡도 O(V+E)

    */

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점의 수
        int E = Integer.parseInt(st.nextToken()); // 간선의 수
        int S = Integer.parseInt(st.nextToken()); // 시작 정점

        visited = new boolean[V + 1];
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 그래프 오름차순 정렬
        for (int i = 0; i <= V; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(S);
        print();
        // 초기화
        visited = new boolean[V + 1];
        result.clear();

        bfs(S);
        print();

    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));

            if (i < result.size() - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }

    static void dfs(int n) {
        visited[n] = true;
        result.add(n);
        for (Integer node : graph.get(n)) {
            if(!visited[node]){
                dfs(node);
            }
        }
    }

    static void bfs(int n) {
        visited[n] = true;
        result.add(n);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while (!queue.isEmpty()) {

            Integer poll = queue.poll();
            for (Integer node : graph.get(poll)) {
                if (!visited[node]) {
                    queue.offer(node);
                    visited[node] = true;
                    result.add(node);
                }
            }
        }
    }
}
