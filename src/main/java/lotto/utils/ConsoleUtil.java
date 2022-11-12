package lotto.utils;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleUtil {

    private ConsoleUtil() {
    }

    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static void showParamMessage(String message, String param) {
        System.out.println(String.format(message, param));
    }

    public static String input() {
        return Console.readLine();
    }



}
