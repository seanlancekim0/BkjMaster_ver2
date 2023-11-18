
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        int t;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                t = Integer.parseInt(st.nextToken());
                if (i != 0) {
                    if (j == 0) {
                        t += tree[i - 1].get(j);
                    } else if (j == i) {
                        t += tree[i - 1].get(j - 1);
                    } else {
                        t += Math.max(tree[i - 1].get(j - 1), tree[i - 1].get(j));
                    }
                }
                tree[i].add(t);
            }
        }

//        System.out.println();
//        for (int i = 0; i < n; i++) {
//            for (int a : tree[i]) {
//                System.out.print(a +" ");
//            }
//            System.out.println();
//        }

        tree[n -1].sort(Comparator.reverseOrder());
        System.out.println(tree[n-1].get(0));
    }
}