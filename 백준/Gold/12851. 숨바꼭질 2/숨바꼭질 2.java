
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 0 ≤ N, K ≤ 100,000
    static int N, K, count;

    static Queue<State> queue;
    static int[] minTime;

    public static void main(String[] args) throws IOException {
        init();

        execute();
    }

    private static void execute() {
        bfs();

        System.out.println(minTime[K]);
        System.out.println(count);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            State p = queue.poll();
//            System.out.println(p.time + " " + p.x);
            if (!isValid(p)) continue;

//            System.out.println("\t\t\t" + p.time + " " + p.x);

            minTime[p.x] = p.time;

            if (p.x == K) {
                count++;
//                System.out.println("------------" + p.time + " " + p.x);
                continue;
            }

            queue.add(new State(p.x + 1, p.time + 1));
            queue.add(new State(p.x - 1, p.time + 1));
            queue.add(new State(p.x * 2, p.time + 1));
        }
    }

    private static boolean isValid(State p) {
        if (p.x < 0 || p.x > 100000 || minTime[K] < p.time || minTime[p.x] < p.time) return false;
        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        count = 0;
        queue = new LinkedList<>();
        minTime = new int[100001];
        for (int i = 0; i < 100001; i++) {
            minTime[i] = Integer.MAX_VALUE;
        }
        queue.add(new State(N, 0));
    }

    private static class State {
        int x;
        int time;

        public State(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
