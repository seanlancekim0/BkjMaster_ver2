
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] map;
    static int[][] dp;
    static boolean[][] visit;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = dp(i, j, Integer.MIN_VALUE);
//                System.out.println("................");
            }
        }

        System.out.println(dp[M - 1][N - 1]);
    }

    private static int dp(int i, int j, int prevHeight) {
        if (isNotDp(i, j, prevHeight)) return 0;

        visit[i][j] = true;

        if (dp[i][j] == -1) {
            dp[i][j] = dp(i - 1, j, map[i][j]) + dp(i + 1, j, map[i][j]) + dp(i, j - 1, map[i][j]) + dp(i, j + 1, map[i][j]);
        }

//        System.out.println(i + " " + j +"  "+ map[i][j]);
//        print();

        visit[i][j] = false;
        return dp[i][j];
    }

    // dp 종료 조건
    private static boolean isNotDp(int i, int j, int prevHeight) {
        if (i < 0 || j < 0 || i >= M || j >= N ||
                prevHeight >= map[i][j] ||
                visit[i][j]
        )
            return true;
        return false;
    }

    // 경로 출력 메소드
    private static void print() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 초기화
    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        visit = new boolean[M][N];

        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 1;
    }
}
/*
2 2
5 4
3 1
 */