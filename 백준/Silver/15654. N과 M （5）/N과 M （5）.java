
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        arr = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            rec( 1, i, "");
        }

        System.out.print(sb);
    }

    private static void rec(int count, int idx, String s) {
        if (visit[idx]) return;
        visit[idx] = true;
        s += arr[idx] + " ";

        for (int i = 0; i < N; i++) {
            rec(count + 1, i, s);
        }

        if (count == M) {
            sb.append(s).append("\n");
        }

        visit[idx] = false;
    }
}
