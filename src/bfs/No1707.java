package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1707 {
    /*
        문제.1707

        그래프의 정점의 집합을 둘로 분할하여,
        각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때,
        그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.

        그래프가 입력으로 주어졌을 때,
        이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.

        입력은 여러 개의 테스트 케이스로 구성되어 있는데,
        첫째 줄에 테스트 케이스의 개수 K가 주어진다.
        각 테스트 케이스의 첫째 줄에는 그래프의 정점의 개수 V와 간선의 개수 E가 빈 칸을 사이에 두고 순서대로 주어진다.
        각 정점에는 1부터 V까지 차례로 번호가 붙어 있다.
        이어서 둘째 줄부터 E개의 줄에 걸쳐 간선에 대한 정보가 주어지는데,
        각 줄에 인접한 두 정점의 번호 u, v (u ≠ v)가 빈 칸을 사이에 두고 주어진다.

        출력은 K개의 줄에 걸쳐 입력으로 주어진 그래프가 이분 그래프이면 YES, 아니면 NO를 순서대로 출력한다.
     */


    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[] color;
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 정점
            int E = Integer.parseInt(st.nextToken()); // 간선

            //초기화
            graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }
            visited = new boolean[V + 1];
            color = new int[V + 1]; // 0: 미방문, 1: 빨강, -1: 파랑
            isBipartite = true;

            // 간선 입력
            for (int i = 1; i <= E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            // 연결되지 않은 정점이 있을 수 있으므로 전체 반복
            for (int i = 1; i <= V; i++) {
                if (!visited[i]) {
                    if(!bfs(i)) break;
                }
            }

            System.out.println(isBipartite ? "YES":"NO");
        }

    }

    static boolean bfs(int root) {

        visited[root] = true; // 정점 방문 여부 체크
        color[root] = 1; // 시작 노드 색 지정

        // 큐 자료구조에 정점 넣기
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        // 큐가 빌 때까지
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (Integer next  : graph.get(current)) {
                if(!visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                    color[next] = -color[current]; // 다른 색으로 칠함
                } else {
                    // 인접한데 색이 같은 경우
                    if (color[next] == color[current]) {
                        isBipartite = false;
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
