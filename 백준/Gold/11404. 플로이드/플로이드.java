
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        int[][] sp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(sp[i], 100000000);
            sp[i][i] = 0;
        }

        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i + 1);
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b, c;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            sp[a - 1][b - 1] = Math.min(sp[a - 1][b - 1], c);
//            Edge edge = new Edge(vertices[a - 1], vertices[b - 1], c);
//            vertices[a - 1].edges.add(edge);
        }

//        Dijkstra(n, vertices[0], sp);
        floydWarshall(n, sp);

        StringBuilder sb = new StringBuilder();
        for (int[] ints : sp) {
            for (int i : ints) {
                if (i == 100000000) {
                    sb.append(0);
                } else {
                    sb.append(i);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void floydWarshall(int n, int[][] sp) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                // 출발지
                if (i == k) continue;
                for (int j = 0; j < n; j++) {
                    // 도착지
                    if (i == j || j == k) continue;
                    if (sp[i][j] > sp[i][k] + sp[k][j]) {
                        sp[i][j] = sp[i][k] + sp[k][j];
                    }
                }
            }
        }
    }


    private static void Dijkstra(int n, Vertex start, int[][] sp) {
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, start, 0));
        boolean[][] visit = new boolean[n][n];

        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            if (!visit[poll.a.v - 1][poll.b.v - 1]) {
                for (Edge e : poll.b.edges) {
                    pq.add(e);
                }
            }
            visit[poll.a.v - 1][poll.b.v - 1] = true;
            sp[poll.a.v - 1][poll.b.v - 1] = Math.min(sp[poll.a.v - 1][poll.b.v - 1], poll.cost);
            for (int i = 0; i < n; i++) {
                sp[i][poll.b.v - 1] = Math.min(sp[i][poll.b.v - 1], sp[i][poll.a.v - 1] + poll.cost);
            }
        }
    }
}

class Vertex {
    int v;
    ArrayList<Edge> edges;

    public Vertex(int v) {
        this.v = v;
        edges = new ArrayList<>();
    }
}

class Edge implements Comparable<Edge> {
    Vertex a, b;
    int cost;

    public Edge(Vertex a, Vertex b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

