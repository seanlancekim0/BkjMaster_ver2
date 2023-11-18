
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Road>[] graph;

    static int N, M, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int S, E, T;
        for (int i = 0; i < TC; i++) {
            st  = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            graph = new ArrayList[N];
            for (int j = 0; j < N; j++) {
                graph[j] = new ArrayList<>();
            }

            //road 입력
            for (int j = 0; j < M; j++) {
                st  = new StringTokenizer(br.readLine());
                S = Integer.parseInt(st.nextToken()) - 1;
                E = Integer.parseInt(st.nextToken()) - 1;
                T = Integer.parseInt(st.nextToken());
                graph[S].add(new Road(E, T));
                graph[E].add(new Road(S, T));
            }

            //wh 입력
            for (int j = 0; j < W; j++) {
                st  = new StringTokenizer(br.readLine());
                S = Integer.parseInt(st.nextToken()) - 1;
                E = Integer.parseInt(st.nextToken()) - 1;
                T = Integer.parseInt(st.nextToken()) * -1;
                graph[S].add(new Road(E, T));
            }

//            System.out.println("\ngraph");
//            for (int j = 0; j < N; j++) {
//                System.out.print(j + 1 + ": ");
//                for (Road r : graph[j]) {
//                    System.out.print((r.v + 1) + "," + r.t + " ");
//                }
//                System.out.println();
//            }

            sb.append(BF() ? "YES" : "NO").append("\n");
        }

        System.out.print(sb);
    }

    private static boolean BF() {
        int[] spl = new int[N];
        Arrays.fill(spl, Integer.MAX_VALUE - 100000);

//        for (int a : spl) {
//            System.out.print(a + " ");
//        }
//        System.out.println();

        spl[0] = 0;
        boolean flag = false;
        for (int j = 1; j < N; j++) {
            flag = false;
            for (int i = 0; i < N; i++) {
                for (Road r : graph[i]) {
                    if (spl[r.v] > spl[i] + r.t)
                    spl[r.v] = spl[i] + r.t;
                    flag = true;
                }
            }

//            for (int a : spl) {
//                System.out.print(a + " ");
//            }
//            System.out.println();

            if (!flag) break;
        }

        if (flag) {
            for (int i = 0; i < N ; i++) {
                for (Road r : graph[i]) {
                    if (spl[r.v] > spl[i] + r.t) return true;
                }
            }
        }

//        for (int a : spl) {
//            System.out.print(a + " ");
//        }
//        System.out.println();

        return false;
    }
}

//도로 클래스
class Road {
    int v;
    int t;

    public Road(int v, int t) {
        this.v = v;
        this.t = t;
    }
}
/*
2
3 3 1

1 2 2
1 3 4
2 3 1

3 1 3

------------------

3 2 1

1 2 3
2 3 4

3 1 8

-----------------

1
3 2 1
2 3 3
3 1 4
1 2 8

-----------------
시작노드 아닌 부분에서 시간돌아가는 경우
1
4 4 1
1 3 2
3 4 4
2 3 5
2 4 3
2 4 4
 */
