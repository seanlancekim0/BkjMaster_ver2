
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static long[] lines;
    static long l, m, r;

    public static void main(String[] args) throws IOException {
        init();

        binarySearch();

        System.out.println(m);
    }

    private static void binarySearch() {
        while (m != l && m != r) {
            long cut = 0;
            for (int i = 0; i < K; i++) {
                cut += lines[i] / m;
            }

//            System.out.println("cut: "+cut);
//            System.out.println(l + " " + m + " " + r);
//            System.out.println();

            if (cut < N) {
                r = m;
                m = (l + m) / 2;
            } else {
                l = m;
                m = (r + m) / 2;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lines = new long[K];
        for (int i = 0; i < K; i++) {
            lines[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(lines);
        l = 0;
        m = lines[0];
        r = lines[K - 1] + 1;
    }
}
/*
4 4
1000000000000
10
100
1000000000000

4 4
1000000000000
10
100
100000

1 100
10000
 */