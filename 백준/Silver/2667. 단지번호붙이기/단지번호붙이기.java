import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N;
    static boolean[][] map;
    static boolean[][] visit;
    static int num;
    static ArrayList<Integer> numbers;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        init();

        execute();
    }

    private static void execute() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isValid(i, j)) {
                    num = 0;
                    dfs(i,j);
                    numbers.add(num);
                }
            }
        }

        Collections.sort(numbers);
        sb.append(numbers.size()).append("\n");
        for (
                int n : numbers) {
            sb.append(n).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int i, int j) {
        if (!isValid(i, j)) return;

        visit[i][j] = true;
        num++;

        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }

    private static boolean isValid(int i, int j) {
        if (i < 0 || j < 0 || i >= N || j >= N || !map[i][j] || visit[i][j]) return false;
        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        visit = new boolean[N][N];
        numbers = new ArrayList<>();
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = row.charAt(j) == '1';
            }
        }
    }
}
