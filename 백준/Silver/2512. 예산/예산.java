
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, min, max;
    static int[] budgets;

    public static void main(String[] args) throws IOException {
        init();

        System.out.println(binarySearch());
    }

    private static int binarySearch() {
        int mid = (min + max) / 2;
        while (min <= max) {
//            System.out.println(min + " " + mid + " " + max);
            int b = Budget(mid);
            if (b < M)
                min = mid + 1;
            else if (b > M)
                max = mid - 1;
            else break;
            mid = (min + max) / 2;
        }
        return Math.min(budgets[N - 1], mid);
    }

    private static int Budget(int mid) {
        int b = 0;
        for (int i = 0; i < N; i++) {

            if (budgets[i] < mid)
                b += budgets[i];

            else b += mid;
        }
//        System.out.println(b);
//        System.out.println();
        return b;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        budgets = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(budgets);

        M = Integer.parseInt(br.readLine());

        min = 1;
        max = budgets[N - 1];
    }
}
