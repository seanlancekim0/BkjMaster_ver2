
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] max = new int[3];
        int[] min = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        min[0] = max[0] = Integer.parseInt(st.nextToken());
        min[1] = max[1] = Integer.parseInt(st.nextToken());
        min[2] = max[2] = Integer.parseInt(st.nextToken());

//        int a, b, c, t0, t2;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int t0 = max[0];
            int t2 = max[2];
            max[0] = a + Math.max(max[0], max[1]);
            max[2] = c + Math.max(max[1], max[2]);
            max[1] = b + Math.max(Math.max(t0, max[1]), t2);

            t0 = min[0];
            t2 = min[2];
            min[0] = a + Math.min(min[0], min[1]);
            min[2] = c + Math.min(min[1], min[2]);
            min[1] = b + Math.min(Math.min(t0, min[1]), t2);
        }

        bw.write(Math.max(Math.max(max[0], max[1]), max[2])+" ");
        bw.write(Math.min(Math.min(min[0], min[1]), min[2])+ "\n");
        bw.flush();
        bw.close();
    }
}

