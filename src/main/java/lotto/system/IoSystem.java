package lotto.system;


import camp.nextstep.edu.missionutils.Console;

public class IoSystem{

    public static String input() {
        return Console.readLine();
    }

    public static void print(final Object message) {
        System.out.print(message);
    }

    public static void println(final Object message) {
        System.out.println(message);
    }
}