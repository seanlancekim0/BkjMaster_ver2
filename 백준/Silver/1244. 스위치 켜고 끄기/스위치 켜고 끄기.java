import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static boolean[] sw;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        execute();
    }

    private static void execute() throws IOException {
        int g, i;
        while (S-- > 0) {
            st = new StringTokenizer(br.readLine());
            g = Integer.parseInt(st.nextToken());
            i = Integer.parseInt(st.nextToken());

            if (g == 1) {
                male(i);
            } else {
                female(i);
            }

        }
        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        for (boolean b : sw) {
            c++;
            if (b) sb.append(1);
            else sb.append(0);
            sb.append(" ");
            if (c % 20 == 0) {
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }

    private static void female(int i) {
        int l = i - 1;
        int r = i - 1;
        while (l >= 0 && r < N) {
            if (sw[l] != sw[r]) break;
            sw[l] = !sw[l];
            if (l != r)
                sw[r] = !sw[r];
            l--;
            r++;
        }
//        print();
    }

    private static void male(int i) {
        int idx = i - 1;
        while (idx < N) {
            sw[idx] = !sw[idx];
            idx += i;
        }
//        print();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        sw = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sw[i] = Integer.parseInt(st.nextToken()) == 1;
        }

        S = Integer.parseInt(br.readLine());
    }
}
