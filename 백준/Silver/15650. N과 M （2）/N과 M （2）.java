
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            add(i, 1, i + "");
        }

        System.out.print(sb);
    }

    private static void add(int s, int l, String str) {
        //무사히 길이가 M인 문자열이 만들어졌을 때 sb에 추가
        if (l == M){
            sb.append(str).append("\n");
            return;
        }
        //길이가 M이 되기 전에 자연수가 N을 초과하는 경우
        if (++s > N) return;
        
        //아직 완성되지 못한 수열들을 재귀로 계속 진행
        for (int i = s; i <= N; i++) {
            add(i, l + 1, str + " " + i);
        }
    }
}
