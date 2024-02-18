
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            add(i, 1, i + "");
        }

        System.out.print(sb);
    }

    private static void add(int s, int l, String str) {
        if (l == M){
            sb.append(str).append("\n");
            return;
        }
        if (++s > N) return;
        for (int i = s; i <= N; i++) {
            add(i, l + 1, str + " " + i);
        }
    }
}
