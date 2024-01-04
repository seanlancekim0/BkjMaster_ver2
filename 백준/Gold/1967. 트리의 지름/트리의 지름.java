
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, w, idx;
    static List<Node>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[p - 1].add(new Node(c, w));
            tree[c - 1].add(new Node(p, w));
        }

        visited = new boolean[n];
        visited[0] = true;
        w = 0;
        idx = 1;
        dfs(1, 0);

        visited = new boolean[n];
        visited[idx - 1] = true;
        w = 0;
        dfs(idx, 0);
        System.out.println(w);
    }

    private static void dfs(int node, int weight) {
        for (Node temp : tree[node - 1]) {
            int tempW = weight + temp.w;
            if (!visited[temp.v - 1]) {
                if (tempW > w) {
                    w = tempW;
                    idx = temp.v;
                }
                visited[temp.v - 1] = true;
                dfs(temp.v, tempW);
            }
        }
    }
}

class Node {
    int v;
    int w;

    Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
}