
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        arr = (ArrayList<Integer>) arr.stream().sorted().collect(Collectors.toList());
//        for (int a: arr) {
//            System.out.print(a+" ");
//        }
//        System.out.println();

        Set<String> set = new HashSet<>();
        boolean[] used = new boolean[N];

        dfs(N, M, 0, used, set, arr, "");

        System.out.print(result);
    }

    private static void dfs(int n, int m, int level, boolean[] used, Set<String> set, ArrayList<Integer> arr, String str) {
        if (level == m && !set.contains(str)) {
            set.add(str);
            result.append(str).append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
//                System.out.println(arr.get(i - 1)+" ");
                used[i] = true;

                dfs(n, m, level + 1, used, set, arr, str + arr.get(i) + " ");

                used[i] = false;
            }
        }
    }
}
