package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ConsoleUtil {

    private ConsoleUtil() {
    }

    public static void showMessage(String message) {
        System.out.println(message);
    }

    /*public static void showParamMessage(String message, int... values) {
        System.out.println(String.format(message, List.of(values)));
    }*/

    public static void showParamMessage(String message, int amount, int rank) {
        System.out.println(String.format(message, amount, rank));
    }

    public static void showParamMessage(String message, double rate) {
        System.out.println(String.format(message, rate));
    }

    public static void showParamMessage(String message, String param) {
        System.out.println(String.format(message, param));
    }

    public static String input() {
        return Console.readLine();
    }



}
