import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, min, max;
    static int[] arr;
    static int[] operator;

    public static void main(String[] args) throws IOException {
        init();

        execute();
    }

    private static void execute() {
        for (int i = 0; i < 4; i++) {
            if (operator[i] != 0) {
                dfs(1, arr[0], i);
            }
        }
        System.out.println(max + "\n" + min);
    }

    private static void dfs(int level, int result, int n) {
        switch (n) {
            case 0 -> result += arr[level];
            case 1 -> result -= arr[level];
            case 2 -> result *= arr[level];
            case 3 -> result /= arr[level];
        }

        if (level == N - 1) {
//            System.out.println(result);
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        operator[n]--;
        for (int i = 0; i < 4; i++) {
            if (operator[i] != 0) {
                dfs(level + 1, result, i);
            }
        }
        operator[n]++;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }
}

/*
6
1 2 3 4 5 6
2 1 1 1
최댓값: 1-2÷3+4+5×6 = 54
최솟값: 1+2+3÷4-5×6 = -24
6
6 5 4 3 2 1
2 1 1 1
최댓값: 6+5×4+3-2÷1 = 45
최솟값: 6%5-4×3+2+1 = -6
 */