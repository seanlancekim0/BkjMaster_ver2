
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long result = 0;
    static List<Jewel> jewels;
    static List<Integer> bags;
    static int K, N;

    public static void main(String[] args) throws IOException {
        init();

        find();

        System.out.println(result);
    }

    private static void find() {

        PriorityQueue<Jewel> pq = new PriorityQueue<>(new JVComparator());
        int j = 0;
        for (int i = 0; i < K; i++) {
            int bp = bags.get(i);
//            System.out.println("bp: " + bp);

            for (; j < N; j++) {
                Jewel jewel = jewels.get(j);
                if (jewel.M > bp) {
                    break;
                }
//                System.out.println("jp.M: " + jp.M + ", jp.V: " + jp.V);
                pq.add(jewel);
            }

            if (pq.isEmpty()) continue;

            result += pq.poll().V;
//            System.out.println("sum+ " + jp.V);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(M, V));
        }
        jewels.sort(new JMComparator() {
        });

        bags = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int C = Integer.parseInt(br.readLine());
            bags.add(C);
        }
        Collections.sort(bags);
    }

    private static class Jewel {
        int M;
        int V;

        public Jewel(int m, int v) {
            M = m;
            V = v;
        }
    }

    private static class JMComparator implements Comparator<Jewel> {
        @Override
        public int compare(Jewel o1, Jewel o2) {
            if (o1.M == o2.M) {
                return o2.V - o1.V;
            }
            return o1.M - o2.M;
        }
    }
    private static class JVComparator implements Comparator<Jewel> {

        @Override
        public int compare(Jewel o1, Jewel o2) {
            return o2.V - o1.V;
        }
    }
}
/*
4 4
1 100
2 200
13 300
10 500
10
10
10
14
답 1100

3 3
20 12
0 20
16 16
17
14
7
36 [o]
 */