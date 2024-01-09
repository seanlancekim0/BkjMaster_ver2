
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[] written = new boolean[26];
    static int R, C, count = 0, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        String str;
        for (int i = 0; i < R; i++) {
            str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j) - 'A';
            }
        }

        dfs(0, 0);

        System.out.println(max);
    }

    private static void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= R || j >= C) return;
        int a = board[i][j];
        if (written[a]) return;
        written[a] = true;
        if (++count > max) {
//            System.out.println(i+","+j);
            max = count;
        }

        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);

        count--;
        written[a] = false;
    }
}
