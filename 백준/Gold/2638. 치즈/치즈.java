
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, count = 0;
    static int[][] ch;
    static boolean[][] visit;
    static boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ch = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                //치즈 없는 부분: 1, 치즈 있는 부분: 0
                ch[i][j] = (Integer.parseInt(st.nextToken()) + 1) % 2;
            }
        }

        ch[0][0] = 4;

        //치즈가 하나라도 녹으면 반복
        while(flag) {

//            for (int[] in : ch) {
//                for (int i : in) {
//                    System.out.print(i + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            flag = false;
            visit = new boolean[N][M];

            space(0, 0);

            hr();

            count++;
        }

        System.out.println(--count);

    }

    private static void hr() {
        //맨 가장자리를 제외한 공간에 대해 실시
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                //상하좌우의 합이 8이상이면 해당좌표 치즈가 녹는다
                if (ch[i][j] == 0 && ch[i - 1][j] + ch[i + 1][j] + ch[i][j - 1] + ch[i][j + 1] >= 8) {
                    flag = true;
                    ch[i][j] = 1;
                }
            }
        }
    }

    //외부 공기: 4, 내부 공간: 1
    private static void space(int i, int j) {
        if (i < 0 || j < 0 || i > N - 1 || j > M - 1 || visit[i][j] || ch[i][j] == 0) return;
        visit[i][j] = true;
        if (ch[i][j] == 1){
            ch[i][j] = 4;
        }

        space(i - 1, j);
        space(i  + 1, j);
        space(i, j - 1);
        space(i, j + 1);
    }
}
/*
8 9
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 1 1 0
0 1 0 1 1 1 0 1 0
0 1 0 0 1 0 0 1 0
0 1 0 1 1 1 0 1 0
0 1 1 0 0 0 1 1 0
0 0 0 0 0 0 0 0 0

8 9
0 0 0 0 0 0 0 0 0
0 1 1 1 1 1 1 1 0
0 1 1 1 1 1 1 1 0
0 1 1 1 1 1 1 1 0
0 1 1 1 1 1 1 1 0
0 1 1 1 1 1 1 1 0
0 1 1 1 1 1 1 1 0
0 0 0 0 0 0 0 0 0

8 9
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 1 1 1 1 1 1 0
0 1 0 1 0 1 0 1 0
0 1 1 1 1 1 1 1 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0

8 9
0 0 0 0 0 0 0 0 0
0 1 1 1 1 1 0 0 0
0 1 1 1 1 1 0 0 0
0 1 1 0 0 1 0 0 0
0 1 1 1 1 0 0 0 0
0 1 1 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0

7 7
0 0 0 0 0 0 0
0 0 0 1 0 0 0
0 0 1 0 1 0 0
0 1 0 1 0 1 0
0 0 1 0 1 0 0
0 0 0 1 0 0 0
0 0 0 0 0 0 0

 */