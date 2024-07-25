
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node[] graph = new Node[N];
//        for (Node n: graph) {
//            System.out.println(n.root);
//        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int val = st.nextToken().charAt(0) - 'A';
            int l = st.nextToken().charAt(0) - 'A';
            int r = st.nextToken().charAt(0) - 'A';
            Node lc = null, rc = null;

            // leftChild
            if (l >= 0) {
                if (graph[l] == null) {
                    lc = new Node(l);
                    graph[l] = lc;
                } else lc = graph[l];
            }

            // rightChild
            if (r >= 0) {
                if (graph[r] == null) {
                    rc = new Node(r);
                    graph[r] = rc;
                } else rc = graph[r];
            }

            // root
            if (graph[val] == null) {
                graph[val] = new Node(val, lc, rc);
            } else{
                graph[val].lc = lc;
                graph[val].rc = rc;
            }
        }

        StringBuilder sb = new StringBuilder();
        preorder(graph, sb);
//        preorder(graph[0], sb);
        sb.append("\n");
        inorder(graph[0], sb);
        sb.append("\n");
        postorder(graph[0], sb);
        System.out.println(sb);

    }

    private static void preorder(Node[] graph, StringBuilder sb) {
        Stack<Node> stack = new Stack<>();
        stack.add(graph[0]);
        while (!stack.isEmpty()) {
            Node p = stack.pop();
            sb.append((char)('A' + p.val));
            if (p.rc != null) stack.add(p.rc);
            if (p.lc != null) stack.add(p.lc);
        }
    }
    private static void preorder(Node n, StringBuilder sb) {
        if (n == null) return;
        sb.append((char) ('A' + n.val));
        preorder(n.lc, sb);
        preorder(n.rc, sb);
    }

    private static void inorder(Node n, StringBuilder sb) {
        if (n == null) return;
        inorder(n.lc, sb);
        sb.append((char) ('A' + n.val));
        inorder(n.rc, sb);
    }

    private static void postorder(Node n, StringBuilder sb) {
        if (n == null) return;
        postorder(n.lc, sb);
        postorder(n.rc, sb);
        sb.append((char) ('A' + n.val));
    }

    private static class Node {
        private int val;
        private Node lc;
        private Node rc;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node lc, Node rc) {
            this.val = val;
            this.rc = rc;
            this.lc = lc;
        }
    }
}
/*
(ASCII). -> -19

A
B   C
D
 */