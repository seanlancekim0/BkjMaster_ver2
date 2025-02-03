
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

            if (ltBudget(mid))
                min = mid + 1;

            else max = mid - 1;
            mid = (min + max) / 2;
        }
        return Math.min(budgets[N - 1], mid);
    }

    private static boolean ltBudget(int mid) {
        int cost = 0;
        for (int i = 0; i < N; i++) {

            if (budgets[i] < mid)
                cost += budgets[i];

            else cost += mid;
        }
//        System.out.println(cost);
//        System.out.println();
        return cost <= M;
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

