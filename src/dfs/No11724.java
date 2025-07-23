package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class No11724 {
    /*
        문제 11724
        방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하기
     */

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static  boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            graph.get(U).add(V);
            graph.get(V).add(U);
        }
        visited =  new boolean[N + 1];

        int connectedComponents = 0;

        // 연결 요소 개수 세기
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                connectedComponents++;
            }
        }

        System.out.println(connectedComponents);
    }

    static void dfs(int current) {

        visited[current] = true;
        for (Integer nextNode : graph.get(current)) {
            if (!visited[nextNode]) {
                dfs(nextNode);
            }
        }
    }
}
