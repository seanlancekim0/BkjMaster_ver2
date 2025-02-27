
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, D;
    static Queue<Edge> pq;
    static List<Edge> used;
    static int result;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        init();

        execute();
    }

    private static void execute() {
        Edge p = pq.poll();
        for (int i = D - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + 1;
//            System.out.println(i + ": " + dp[i]);
            while (p != null && i == p.u) {
//                System.out.println(i + ": " + dp[i] + ", (" + p.u + " " + p.v + ") " + p.w + "+" + dp[p.v]);
                dp[i] = Math.min(dp[i], p.w + dp[p.v]);
                p = pq.poll();
            }
        }
        System.out.println(dp[0]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        result = D;
        used = new ArrayList<>();
        dp = new int[D + 1];

        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (v > D || v - u - w <= 0) continue;
//            System.out.println(u + " " + v + " " + ((v - u - w) / (v - u)));
            pq.add(new Edge(u, v, w));
        }
    }

    private static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {
            return e.u - this.u;
        }
    }
}
/*
5 150
0 50 20
0 50 10
50 100 10
100 151 10
110 140 90
 */