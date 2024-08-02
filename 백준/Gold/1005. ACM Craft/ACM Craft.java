
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Integer>[] graph;
    private static int[] bTime;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            bTime = new int[N + 1];
            dp = new int[N + 1];
            graph = new ArrayList[N + 1];
//            Arrays.fill(graph, new ArrayList<>());
            for (int i = 1; i <= N; i++) {
                bTime[i] = Integer.parseInt(st.nextToken());
                dp[i] = -1;
                graph[i] = new ArrayList<>();
            }

            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph[c].add(p);
            }

//            for (int j = 1; j <= N; j++) {
//                System.out.print(j + ": ");
//                for (Integer i : graph[j]) {
//                    System.out.print(" " + i);
//                }
//                System.out.println();
//            }

            int W = Integer.parseInt(br.readLine());
            sb.append(min(W)).append("\n");
        }
        System.out.print(sb);
    }

    private static int min(int c) {
        if (graph[c].isEmpty()){
            dp[c] = bTime[c];
        } else if (dp[c] >= 0) {
            return dp[c];
        } else {
            int time = 0;
            for (Integer b : graph[c]) {
                time = Math.max(time, min(b));
            }
            dp[c] = bTime[c] + time;
        }
//        System.out.println("c: " + c + ", time: " + dp[c]);
        return dp[c];
    }
}
/*
그래프 탐색의 끝에 다다랐을 때 모든 건물에 visit했다면 그때까지 걸린 시간이 최소시간이다.
visit의 기준이 Node가 아닌 Edge여야 한다.

특정 건물 W를 건설할 때 걸리는 최소시간이다. 모든 건물이 지어질 필요가 없다.
건물 W를 짓기 위한 조건이 주어지므로 해당 조건들을 역추적해야한다.
-> 재귀를 사용해보자!

dp..?
 */
