import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] dp;
    static int[] stair;

    public static void main(String[] args) throws IOException {
        init();

        dp();

        System.out.println(dp[N]);
    }

    private static void dp() {
        dp[1] = stair[1];
        if (N > 1) {
            dp[2] = stair[1] + stair[2];
        }
        if (N > 2) {
            dp[3] = Math.max(dp[1], stair[2]) + stair[3];

        }
        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i];
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        stair = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
    }
}
