
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int N;
    static int[] card;
    static Queue<Integer> pq;

    public static void main(String[] args) throws IOException {
        init();

        execute();
    }

    private static void execute() {
        int result = 0;
        int sum = 0;
        while (pq.size() > 1) {
            int p1 = pq.poll();
            int p2 = pq.poll();
            sum = p1 + p2;
            result += sum;
            pq.add(sum);
        }
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        card = new int[N];
        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
    }
}
/*
4
10
30
40
40
-> 240
 */