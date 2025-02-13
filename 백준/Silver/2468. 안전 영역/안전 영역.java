
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, max;
    static int[] dx, dy;
    static int[][] heights;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        init();

        execute();
    }

    private static void execute() {
        int result = 1;
        for (int h = 1; h <= max; h++) {
            int count = 0;
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (heights[i][j] > h && !visit[i][j]) {
                        count++;
                        dfs(i, j, h);
                    }
                }
            }
            result = Math.max(result, count);
        }
        System.out.println(result);
    }

    private static void dfs(int x, int y, int h) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (isValid(nx, ny, h)) {
                dfs(nx, ny, h);
            }
        }
    }

    private static boolean isValid(int nx, int ny, int h) {
        return (nx >= 0 && nx < N) && (ny >= 0 && ny < N) && !visit[nx][ny] && heights[nx][ny] > h;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        heights = new int[N][N];
        dx = new int[]{1, -1, 0, 0};
        dy = new int[]{0, 0, 1, -1};
        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                heights[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(heights[i][j], max);
            }
        }
    }
}
