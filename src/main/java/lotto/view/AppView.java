package lotto.view;

import java.util.Scanner;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class AppView {
    static Scanner scanner = new Scanner(System.in);

    public static void output(String message) {
        System.out.print(message);
    }

    public static void outputLine(String message) {
        System.out.println(message);
    }

    public static String inputLine() {
        String line = readLine();
        return line;
    }
}
