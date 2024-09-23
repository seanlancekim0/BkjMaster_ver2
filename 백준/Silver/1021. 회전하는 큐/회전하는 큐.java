
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] input;
    static Queue<Integer> cirQ;

    public static void main(String[] args) throws IOException {
        init();

        execute();
    }

    private static void execute() {
        int result = 0;
        for (int m : input) {
            int count = 0;
            while (cirQ.element() != m) {
                count++;
                cirQ.add(cirQ.poll());
            }

            result += Math.min(count, cirQ.size() - count);
//            System.out.println("result: "+result);
            cirQ.poll();
        }
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cirQ = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            cirQ.add(i);
        }

        input = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
    }
}
