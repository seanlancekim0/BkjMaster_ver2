
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] bridge;
    static int result;
    static Queue<Node> queue;


    public static void main(String[] args) throws IOException {
        init();

        bfs();

        System.out.println(result);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int count = node.count;
            int s = node.start;
            int e = node.end;
            int l = node.length;

            if (l % bridge[s] == 0) {
                result = count;
                return;
            }

            int i = (s - 1) / bridge[s] * -1;
            while (s + bridge[s] * i <= N) {
                if (i != 0)
                    queue.add(new Node(count + 1, s + bridge[s] * i, e, Math.abs(e - s - bridge[s] * i)));
                i++;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        bridge = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        queue.add(new Node(1, a, b, Math.abs(b - a)));
        result = -1;
    }

    private static class Node {
        int count;
        int start;
        int end;
        int length;

        public Node(int count, int start, int end, int length) {
            this.count = count;
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }
}
    /*
    5
    1 5 3 3 9
    4 5
     */