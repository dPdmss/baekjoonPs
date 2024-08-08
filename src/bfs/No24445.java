package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No24445 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 입력받을 2차원 배열
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        result = new int[N + 1];

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

        bfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 1;
        result[start] = count;

        while (!queue.isEmpty()) {

            int index = queue.poll();
            List<Integer> list = graph.get(index);
            list.sort(Collections.reverseOrder()); // 내림차순 정렬
            for (Integer i : list) {
                if(!visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                    result[i] = ++count;
                }
            }
        }
    }
}
