
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int mid, M, N, min, max;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        int temp = Integer.parseInt(st.nextToken());
//        min = temp;
        min = 0;
        max = temp;
        list.add(temp);

        for (int i = 1; i < N; i++) {
            temp = Integer.parseInt(st.nextToken());
//            min = Math.min(temp, min);
            max = Math.max(temp, max);
            list.add(temp);
//            System.out.println("min: " + min + " max: " + max);
        }
//        System.out.println();

//        BSearchIter();
        BSearchRec();
        System.out.print(mid);

    }

    private static void BSearchRec() {
        long result = 0;
        mid = (min + max) / 2;
        for (int a: list) {
            int diff = a - mid;
            if (diff > 0) result += diff;
        }
        if (result == M) return;
        if (result > M) {
            min = mid + 1;
            if (min > max) return;
        } else {
            max = mid - 1;
        }
        BSearchRec();
    }

    private static void BSearchIter() {
        long result = 0;

        // 수정된 부분: 재귀 호출 대신 반복문을 사용하여 이진 탐색을 수행
        while (min <= max) {
            System.out.println("min: " + Main.min + " max: " + Main.max);
            mid = (min + max) / 2;
            System.out.println("mid: "+mid);
            result = 0;

            for (int a : list) {
                int diff = a - mid;
                if (diff > 0) result += diff;
            }

            System.out.println("result: " + result);
            System.out.println();
            if (result == M) return;
            else if (result > M) {
                min = mid + 1;
//                if (min == max) {
//                    break;
//                }
            } else {
                max = mid - 1;
            }
        }
        if (result < M) mid--;
    }
}
