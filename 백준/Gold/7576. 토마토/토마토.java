import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, total, count, result;
    static int[][] field;
    static Queue<State> queue;

    public static void main(String[] args) throws IOException {
        init();

        execute();
    }

    private static void execute() {
        bfs();

        if (total > count) result = -1;

        System.out.println(result);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            State p = queue.poll();
            if (!isValid(p)) continue;

            field[p.i][p.j] = 1;
            result = p.day;
            count++;
            
//            print();

            queue.add(new State(p.i + 1, p.j, p.day + 1));
            queue.add(new State(p.i - 1, p.j, p.day + 1));
            queue.add(new State(p.i, p.j + 1, p.day + 1));
            queue.add(new State(p.i, p.j - 1, p.day + 1));
        }
    }

    private static void print() {
        System.out.println(result);
        for (int[] fi : field) {
            for (int f : fi) {
                System.out.print(f + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }

    private static boolean isValid(State p) {
        if (p.i < 0 || p.j < 0 || p.i >= N || p.j >= M || field[p.i][p.j] != 0) return false;
        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        total = 0;
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int t = Integer.parseInt(st.nextToken());
                if (t != -1) total++;
                field[i][j] = t;
                if (t == 1) {
                    queue.add(new State(i, j, 0));
                    field[i][j] = 0;

                }

            }
        }
    }

    private static class State {
        int i;
        int j;
        int day;

        public State(int i, int j, int day) {
            this.i = i;
            this.j = j;
            this.day = day;
        }
    }
}
