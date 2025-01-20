
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, min;
    static int[][] S;
    static boolean[] isStart;

    public static void main(String[] args) throws IOException {
        init();

        execute();
    }

    private static void execute() {
        dfs(0, 0);

        System.out.println(min);
    }

    private static void dfs(int count, int n) {
        if (count == N / 2) {
            int teamS = 0;
            int teamL = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (isStart[i] && isStart[j]) {
                        teamS += S[i][j];
                        teamS += S[j][i];
                    }
                    if (!isStart[i] && !isStart[j]) {
                        teamL += S[i][j];
                        teamL += S[j][i];
                    }
                }
            }
            min = Math.min(min, Math.abs(teamS - teamL));
        }

        for (int i = n; i < N; i++) {
            if (!isStart[i]) {
                isStart[i] = true;
                dfs(count + 1, i);
                isStart[i] = false;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isStart = new boolean[N];
        min = Integer.MAX_VALUE;

        S = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
