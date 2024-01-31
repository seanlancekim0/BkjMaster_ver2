
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    static int N, count = 0;
    static boolean[] check1, check2, check3;
    static int[] x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        check1 = new boolean[100];
        check2 = new boolean[100];
        check3 = new boolean[100];
        x = new int[100];

        nQueen(0);

        System.out.println(count);
    }

    private static void nQueen(int w) {
        if (w == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (check1[i] || check2[w + i] || check3[w - i + N]) {
                continue;
            }
            check1[i] = check2[w + i] = check3[w - i + N] = true;
            x[w] = i;
            nQueen(w + 1);
            check1[i] = check2[w + i] = check3[w - i + N] = false;
        }
    }
}
/*
3x3 보드가 있는데 퀸이 한 자리에 놓이면 대각선 위아래로 다른 퀸이 놓일 수 없다.
x x x x
x x o o
x o x o
x o o x

1 : 1
2 : 0
3 : 0
4 :
*/