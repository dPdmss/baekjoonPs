package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No24479 {
    /*

    문제 24479

    dfs(V, E, R) {  # V : 정점 집합, E : 간선 집합, R : 시작 정점
    visited[R] <- YES;  # 시작 정점 R을 방문 했다고 표시한다.
    for each x ∈ E(R)  # E(R) : 정점 R의 인접 정점 집합.(정점 번호를 오름차순으로 방문한다)
        if (visited[x] = NO) then dfs(V, E, x);
    }

    입력 값
    정점의 수 5 <= N <= 100,000
    간선의 수 1 <= M <= 200,000
    시작 정점 1 <= R <= N
    간선의 정보 U, V

    시간 복잡도
    모든 그래프의 정점과 간선을 한 번씩 확인하므로 O(N+M)

    */

    static boolean[] visited; // 정점별 방문 여부
    static int[] result;    // 정점별 방문 순서
    static int cnt = 1;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 무방향 그래프
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 집합
        int M = Integer.parseInt(st.nextToken()); // 간선 집합
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        visited = new boolean[N + 1];
        result = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            // 양방향 노드로 둘다 이어줘야함
            graph.get(U).add(V);
            graph.get(V).add(U);
        }
        // 오름차순 정렬
        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(R);

        StringBuffer sb = new StringBuffer();
        for (int i=1; i<result.length; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int R) {
        visited[R] = true;
        result[R] = cnt++;

        Iterator<Integer> iterator = graph.get(R).iterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if (!visited[next]) {
                dfs(next);
            }
        }

    }
}
