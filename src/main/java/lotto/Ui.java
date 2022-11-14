package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Ui {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public String returnInputValue(String message) {
        System.out.println(message);
        String input = Console.readLine();
        return input;
    }
}
