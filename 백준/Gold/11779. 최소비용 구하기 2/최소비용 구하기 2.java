
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, A, B;
    static List<Edge>[] graph;
    static Queue<Edge> pq;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        init();

        execute();
    }

    private static void execute() {
        Edge result = dijkstra();

        StringBuilder sb = new StringBuilder();
        sb.append(result.l).append("\n");
        sb.append(result.count).append("\n");
        sb.append(result.path);
        System.out.println(sb);
    }

    private static Edge dijkstra() {
        while (!pq.isEmpty()) {
            Edge p = pq.poll();
            if (visit[p.v]) continue;
            visit[p.v] = true;

            if (p.v == B) {
                return p;
            }

            for (Edge e : graph[p.v]) {
                if (p.l + e.w < e.l) {
                    e.l = p.l + e.w;
                    e.count = p.count + 1;
                    e.path = p.path + " " + e.v;
                }
                pq.add(e);
            }
        }
        return new Edge();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w, Integer.MAX_VALUE, 0, ""));
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        pq.add(new Edge(A, 0, 0, 1, A + ""));
    }

    private static class Edge implements Comparable<Edge> {
        int v;
        int w;
        int l;
        int count;
        String path;

        public Edge() {
        }

        public Edge(int v, int w, int l, int count, String path) {
            this.v = v;
            this.w = w;
            this.l = l;
            this.count = count;
            this.path = path;
        }

        @Override
        public int compareTo(Edge e) {
            return this.l - e.l;
        }
    }
}
