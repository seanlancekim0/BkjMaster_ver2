
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int n;
        int[][] score, dp;
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            score = new int[2][n];
            dp = new int[2][n];
            //스티커 점수 입력
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    score[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = score[0][0];
            dp[1][0] = score[1][0];
            if (n > 1) {
                dp[0][1] = dp[1][0] + score[0][1];
                dp[1][1] = dp[0][0] + score[1][1];
            }

            for (int j = 2; j < n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + score[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + score[1][j];
            }
            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
        }
        System.out.print(sb);
    }
}
