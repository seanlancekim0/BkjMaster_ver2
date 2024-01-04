
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Node implements Comparable<Node> {
        int n;
        int w;
        int l;

        public Node(int n, int w, int l) {
            this.n = n;
            this.w = w;
            this.l = l;
        }

        @Override
        public int compareTo(Node o) {
            return this.l - o.l;
        }
    }

    static int N, M, X;
    static ArrayList<Node> [] graph;
    static int[] spl;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;

        //그래프 입력하기
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        int u, v, w;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken()) - 1;
            v = Integer.parseInt(st.nextToken()) - 1;
            w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w, Integer.MAX_VALUE));
        }

        spl = new int[N];
        spl[X] = 0;

        dijkstra();
//        System.out.println("----------------------------------");
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    graph[i].get(j).l = Integer.MAX_VALUE;
                }
            }
            dijkstra(k);
        }
        Arrays.sort(spl);
        System.out.println(spl[N - 1]);
    }

    private static void dijkstra(int s) {
        boolean[] visit = new boolean[N];
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0, 0));

        for (int i = 0; i < graph[s].size(); i++) {
            graph[s].get(i).l = graph[s].get(i).w;
        }

        while (!pq.isEmpty()) {
            Node p = pq.poll();
            if (visit[p.n]) continue;
            visit[p.n] = true;
            if (p.n == X) {
                spl[s] += p.l;

//                System.out.println("n:" + (s + 1) + " l:" + p.l);
//                for (int i = 0; i < N; i++) {
//                    System.out.print(i + 1 + ":" + spl[i] + " ");
//                }
//                System.out.println();
//                System.out.println();

                break;
            }

            for (int i = 0; i < graph[p.n].size(); i++) {
                Node n = graph[p.n].get(i);
                n.l = Math.min(n.l, p.l + n.w);
                pq.add(n);
            }
        }
    }

    private static void dijkstra() {
        boolean[] visit = new boolean[N];
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0, 0));

        for (int i = 0; i < graph[X].size(); i++) {
            graph[X].get(i).l = graph[X].get(i).w;
        }

        while (!pq.isEmpty()) {
            Node p = pq.poll();
            if (visit[p.n]) continue;
            visit[p.n] = true;
            spl[p.n] = p.l;

//            System.out.println("n:" + (p.n + 1) + " l:" + p.l);
//            for (int i = 0; i < N; i++) {
//                System.out.print(i + 1 + ":" + spl[i] + " ");
//            }
//            System.out.println();

            for (int i = 0; i < graph[p.n].size(); i++) {
                Node n = graph[p.n].get(i);
                n.l = Math.min(n.l, p.l + n.w);
                pq.add(n);
//                System.out.print((p.n + 1) + "-" + (n.n + 1) + ":" + n.l + " ");
            }
//            System.out.println();
//            System.out.println();
        }
    }
}
