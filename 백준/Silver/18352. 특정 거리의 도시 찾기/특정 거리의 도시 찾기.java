import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static int[] sl;
    static Queue<Edge> queue;
    static List<Integer>[] graph;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        init();

        execute();
    }

    private static void execute() {
        queue.add(new Edge(X, X));

        dijkstra();


        if (result.isEmpty()) {
            System.out.println(-1);
            return;
        }

        result.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (int i : result) sb.append(i).append("\n");
        System.out.print(sb);
    }

    private static void dijkstra() {
        while (!queue.isEmpty()) {
            Edge p = queue.poll();
//            System.out.println(p.u + " " + p.v);
            int l = sl[p.u] + 1;
            if (l > K || sl[p.v] != -1) continue;

            sl[p.v] = l;
            if (l == K) result.add(p.v);
//            for (int i = 1; i <= N; i++) {
//                System.out.println(i + ": " + sl[i]);
//            }
            for (int i = 0; i < graph[p.v].size(); i++) {
                if (sl[graph[p.v].get(i)] == -1) {
//                    System.out.println("add: " + p.v + " " + graph[p.v].get(i));
                    queue.add(new Edge(p.v, graph[p.v].get(i)));
                }
            }
//            System.out.println();
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        sl = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sl[i] = -1;
        }
//        Arrays.fill(sl, -1);
        queue = new LinkedList<>();
        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
//        Arrays.fill(graph, new ArrayList<>());
        result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
        }
    }

    private static class Edge {
        int u;
        int v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
}
