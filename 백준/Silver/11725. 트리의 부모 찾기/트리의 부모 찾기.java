
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tree = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }
        parent = new int[N + 1];

        //tree 생성
        int u, v;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        //bfs로 탐색하면서 부모 노드번호 저장
        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N + 1; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        queue.add(1);
        int p;
        while (!queue.isEmpty()) {
            p = queue.poll();
            if (visit[p]) continue;
            visit[p] = true;
            for (int node : tree[p]) {
                queue.add(node);
                if (parent[node] == 0) parent[node] = p;
            }
        }

    }
}
