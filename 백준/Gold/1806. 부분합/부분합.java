
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        init();

        System.out.println(find());
    }

    private static int find() {
        if (arr[N] < S) return 0;

        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;

        while (l < N || r < N) {
            int val = arr[r] - arr[l];

//            System.out.println("l: " + l + ", r: " + r + ", val: " + val);

            if (val < S) {
                if (r < N) {
                    r++;
                } else {
                    l++;
                }
            } else {
                min = Math.min(min, r - l);
                l++;
            }

//            System.out.println("min: "+min+"\n");

        }

        return min;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
    }
}
/*
1 2 3 4 5
12 23 34 45
123 234

input:
10 8
4 1 1 1 1 1 2 2 2 2
output: 5
answer: 4

10 5
5 2 3 2 3 2 3 2 3 2
정답 : 1

10 10
3 1 1 1 2 2 2 2 2 2

4 2 2 3 4 4 4 4 4
5 3 4 5 6 6 6 6
6 5 6 7 8 8 8
8 7 8 9 10
 */