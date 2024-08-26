
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] acid;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        init();

        find();

        System.out.println(sb);
    }

    private static void find() {
        int lp = 0, rp = N - 1, sum, min = Integer.MAX_VALUE, lm = 0, rm = 0;
        while (lp < rp) {
            sum = acid[rp] + acid[lp];
            if (Math.abs(min) > Math.abs(sum)) {
                min = sum;
                lm = acid[lp];
                rm = acid[rp];
            }
            if (sum < 0) {
                lp++;
            } else {
                rp--;
            }
        }
        sb.append(lm).append(" ").append(rm);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        acid = new int[N];
        for (int i = 0; i < N; i++) {
            acid[i] = Integer.parseInt(st.nextToken());
        }
    }
}

/*
3
-1000 -100 -10
 */