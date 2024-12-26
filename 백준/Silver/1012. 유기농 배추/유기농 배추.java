
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][M];

            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            int count = 0;
            for (int k = 0; k < N * M; k++) {
                if(arr[k / M][k % M] == 1) {
                    count++;
                    arr = arrCheck(arr, k / M, k % M);
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] arrCheck(int[][] arr, int x, int y) {
        arr[x][y] = -1;
        if(x > 0 && arr[x - 1][y] == 1) arr = arrCheck(arr, x - 1, y);
        if(x < arr.length - 1 && arr[x + 1][y] == 1) arr = arrCheck(arr, x + 1, y);
        if(y > 0 && arr[x][y - 1] == 1) arr = arrCheck(arr, x, y - 1);
        if(y< arr[0].length - 1 && arr[x][y + 1] == 1) arr = arrCheck(arr, x, y + 1);
        return arr;
    }
}