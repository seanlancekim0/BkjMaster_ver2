
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, M, N, K;
    static boolean[][] fields;
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder result;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        result = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            fields = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                fields[n][m] = true;
            }

            execute();
        }

        System.out.print(result);
    }

    private static void execute() throws IOException {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (fields[i][j]) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        result.append(count).append("\n");
    }

    private static void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= N || j >= M || !fields[i][j]) return;
        fields[i][j] = false;
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
}
