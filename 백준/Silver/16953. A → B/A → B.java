
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int A, B, result;
    static Queue<State> queue;

    public static void main(String[] args) throws IOException {
        init();

        execute();
    }

    private static void execute() {
        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            State p = queue.poll();
//            System.out.println(p.v);
            if (p.v == B) {
                result = p.n;
                break;
            }
            if (p.v > B) continue;
            queue.add(new State(p.n + 1, p.v * 2));
            queue.add(new State(p.n + 1, p.v * 10 + 1));
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        result = -1;
        queue = new LinkedList<>();
        queue.add(new State(1, A));
    }


    private static class State {
        int n;  // 연산 횟수
        long v;  // 연산값

        public State(int n, long v) {
            this.n = n;
            this.v = v;
        }
    }
}
/*
1 1000000000
 */