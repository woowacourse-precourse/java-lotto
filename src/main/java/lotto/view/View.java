package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public abstract class View {
    public abstract void show();

    public String getResponse() {
        return "";
    }

    public static void printLineFormat(String format, Object ...args) {
        printLine(String.format(format, args));
    }

    public static void printLine(String message) {
        System.out.println(message);
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static String readLine(String message) {
        printLine(message);

        return Console.readLine();
    }
}
