import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int x, y;
    static int[] months;

    public static void main(String[] args) throws IOException {
        init();

        find();
    }

    private static void find() {
        int day = 0;
        for (int i = 1; i < x; i++) {
            day += months[i];
        }
        day += y - 1;
        day %= 7;

        switch (day) {
            case 0 -> System.out.println("MON");
            case 1 -> System.out.println("TUE");
            case 2 -> System.out.println("WED");
            case 3 -> System.out.println("THU");
            case 4 -> System.out.println("FRI");
            case 5 -> System.out.println("SAT");
            case 6 -> System.out.println("SUN");
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        months = new int[13];
        months[1] = 31;
        months[2] = 28;
        months[3] = 31;
        months[4] = 30;
        months[5] = 31;
        months[6] = 30;
        months[7] = 31;
        months[8] = 31;
        months[9] = 30;
        months[10] = 31;
        months[11] = 30;
        months[12] = 31;
    }
}
