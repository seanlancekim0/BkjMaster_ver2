import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 0 ≤ N, K ≤ 100,000
    static int N, K, count;
    static Queue<State> queue;
    // 각 지점의 최소시간을 저장하는 배열
    static int[] minTime;

    public static void main(String[] args) throws IOException {
        init();

        execute();
    }

    private static void execute() {
        bfs();

        System.out.println(minTime[K]);
        System.out.println(count);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            State p = queue.poll();

            // [총 최소시간]보다 [현재 State의 소요시간]이 큰 경우 break
            if (minTime[K] < p.time) break;
            if (!isValid(p)) continue;

            // minTime 배열에 해당 지점의 최소시간 저장
            minTime[p.x] = p.time;

            // 목표 지점에 도달했을 때 count 증가
            if (p.x == K) {
                count++;
                continue;
            }

            queue.add(new State(p.x + 1, p.time + 1));
            queue.add(new State(p.x - 1, p.time + 1));
            queue.add(new State(p.x * 2, p.time + 1));
        }
    }

    // 유효 판별 메소드
    private static boolean isValid(State p) {
        // [해당 지점의 최소시간]보다 [현재 State의 소요시간]이 큰 경우 invalid함
        if (p.x < 0 || p.x > 100000 || minTime[p.x] < p.time) return false;
        return true;
    }

    // 초기화 메소드
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        count = 0;
        queue = new LinkedList<>();
        queue.add(new State(N, 0));

        // minTime 배열은 MAX 값으로 초기화
        minTime = new int[100001];
        Arrays.fill(minTime, Integer.MAX_VALUE);
    }

    // Queue에 저장할 상태 Class
    private static class State {
        // 좌표
        int x;
        // 소요시간
        int time;

        public State(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
