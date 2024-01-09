
//3차원 배열이라... 다시 풀어라!
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][][] visit;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new int[2][N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visit[0][i], Integer.MAX_VALUE);
            Arrays.fill(visit[1][i], Integer.MAX_VALUE);
        }

        String str;
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(0, 0, 1, false));
        while (!queue.isEmpty()) {
            Cell p = queue.poll();
            if (map[p.i][p.j] == 1 && p.b) {
                continue;
            }
            if (!p.b) {
                if (p.l >= visit[0][p.i][p.j]){
                    continue;
                }
            } else {
                if (p.l >= visit[1][p.i][p.j]){
                    continue;
                }
            }

//            System.out.print(p.i + " " + p.j + " " + p.l + " ");
            if (!p.b) {
                visit[0][p.i][p.j] = p.l;
            } else {
                visit[1][p.i][p.j] = p.l;
            }

            if (p.i == N - 1 && p.j == M - 1) {
                return p.l;
            }

            if (map[p.i][p.j] == 1 && !p.b) p.b = true;

//            System.out.println(p.b);

            p.l++;
            if (p.i - 1 >= 0) queue.add(new Cell(p.i - 1, p.j, p.l, p.b));
            if (p.i + 1 < N) queue.add(new Cell(p.i + 1, p.j, p.l, p.b));
            if (p.j - 1 >= 0) queue.add(new Cell(p.i, p.j - 1, p.l, p.b));
            if (p.j + 1 < M) queue.add(new Cell(p.i, p.j + 1, p.l, p.b));

        }
        return -1;
    }

    private static class Cell {
        int i;
        int j;
        int l;
        boolean b;

        public Cell(int i, int j, int l, boolean b) {
            this.i = i;
            this.j = j;
            this.l = l;
            this.b = b;
        }
    }
}
/*
6 6
010000
000000
000000
000000
000001
000010

3 3
001
101
110

5 6
000000
101111
001011
011010
000010
 */