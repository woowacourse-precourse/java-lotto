package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoPrinter {
    public static String inputer(String message) {
        System.out.println(message);
        String inputValue = Console.readLine();
        System.out.println();
        return inputValue;
    }
}
