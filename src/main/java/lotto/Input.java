package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static final String submit(String message) {
        System.out.println(message);
        String inputValue = Console.readLine();
        System.out.println();
        return inputValue;
    }
}
