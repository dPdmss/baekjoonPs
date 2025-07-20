package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2606 {
    /*
        문제 2606번 바이러스

        바이러스는 네트워크를 통해 전파된다

        네트워크 연결 구조 예시
        1-2-5
        2-3
        5-6
        4-7

        1번과 연결된 컴퓨터 2,5를 통해 3,6까지 바이러스에 전염된다
        V : 컴퓨터 수 V <= 100
        E : 네트워크 연결 정보

        1번 컴퓨터를 통해 바이러스에 걸리게 되는 컴퓨터 수 출력

        시간복잡도 계산

     */

    public static List<List<Integer>> graph = new ArrayList<>(); // 양방향 그래프
    public static boolean[] visited; // 정점 방문 여부
    public static int cnt = 0; // (시작 정점 제외)방문한 정점의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine()); // 정점 수
        int E = Integer.parseInt(br.readLine()); // 간선 수
        int R = 1; // 시작 정점

        visited = new boolean[V + 1];

        for (int i = 0; i<= V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            graph.get(n).add(m);
            graph.get(m).add(n);
        }
        dfs(R);

        System.out.println(cnt);
    }

    static void dfs(int root) {
//        if(visited[root]) return;
        visited[root] = true;

//        if(root != 1)cnt++;
       /* Iterator<Integer> iterator = graph.get(root).iterator();
        while (iterator.hasNext()) {
            dfs(iterator.next());
        }*/

        for (Integer next : graph.get(root)) {
            if (!visited[next]) {
                cnt++;
                dfs(next);
            }
        }
    }
}
