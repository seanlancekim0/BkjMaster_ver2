
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int x, y;
    static int[] months;
    static String[] days;

    public static void main(String[] args) throws IOException {
        init();

        find();
    }

    private static void find() {
        int index = 0;
        for (int i = 0; i < x - 1; i++) {
            index += months[i];
        }
        index += y - 1;
        index %= 7;

        System.out.println(days[index]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        days = new String[]{"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    }
}
