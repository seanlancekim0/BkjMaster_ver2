
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //맵을 저장하는 배열
    static int[][] map;

    //방문한 노드의 최단거리를 저장하는 배열
    static int[][][] visit;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        //방문한 노드들의 최단거리를 벽을 부순 경우와 벽을 부수지 않은 경우를 독립적으로 계산하기 위해 따로 분리함.
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

            //이미 벽을 부순 경로에서 벽을 만난 경우 continue;
            if (map[p.i][p.j] == 1 && p.b) {
                continue;
            }

            //현재 경로의 길이가 visit 배열에 저장된 최단거리보다 긴 경우 continue;
            //벽을 깬경우와 깨지 않은 경우의 최단거리를 한 배열에 저장하면
            // 그 이후의 탐색에서 벽을 깨고 더 짧은 거리를 찾을 수 있는 경우가 존재하는 경우를 처리하지 못함
            if (!p.b) {
                if (p.l >= visit[0][p.i][p.j]){
                    continue;
                }
            } else {
                if (p.l >= visit[1][p.i][p.j]){
                    continue;
                }
            }

            //현재 경로가 최단거리인 경우 visit배열 갱신
            if (!p.b) {
                visit[0][p.i][p.j] = p.l;
            } else {
                visit[1][p.i][p.j] = p.l;
            }

            //도착지에 도착한 경우 현재의 거리를 return, bfs이기 때문에 가장 먼저 return한 값이 최단거리
            if (p.i == N - 1 && p.j == M - 1) {
                return p.l;
            }

            //벽을 깬 적이 없는데 벽을 만난 경우 벽을 깨고 진행
            if (map[p.i][p.j] == 1 && !p.b) p.b = true;

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