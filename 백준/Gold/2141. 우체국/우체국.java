
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static long sumA;
    static PriorityQueue<Village> pq;

    public static void main(String[] args) throws IOException {
        init();

        execute();
    }

    private static void execute() {
        long tempA = 0;
        long result = 0;
        for (int i = 0; i < N; i++) {
            Village p = pq.poll();
//            System.out.println(p.x + " " + p.a);
            tempA += p.a;
            if ((sumA + 1) / 2 <= tempA) {
                result = p.x;
                break;
            }
        }

        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sumA = 0;
        StringTokenizer st;
        pq = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            pq.add(new Village(x, a));
            sumA += a;
        }
    }

    private static class Village implements Comparable<Village> {
        int x;
        int a;

        public Village(int x, int a) {
            this.x = x;
            this.a = a;
        }

        @Override
        public int compareTo(Village o) {
            return this.x - o.x;
        }
    }
}
/*
4
10 1
20 3
25 2
40 2
-> 20

2
1 1
2 2
->  2

2
1 3
2 3
-> 1
 */