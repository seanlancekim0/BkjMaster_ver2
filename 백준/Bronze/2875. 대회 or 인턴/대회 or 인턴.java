
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        init();

        execute();
    }

    private static void execute() {
        int result = 0;
        int lack;
        result = Math.min(N / 2, M);
        lack = K - (M + N - result * 3);
        if (lack > 0) {
            result -= lack / 3;
            if (lack % 3 != 0) result -= 1;
        }
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}
