package lotto;

import camp.nextstep.edu.missionutils.Console;

import javax.swing.*;
import java.util.regex.Pattern;

public class Input {
    private Input() {

    }

    private static String input() {
        return Console.readLine();
    }

    public static String inputBudget() throws IllegalArgumentException {
        String budget = input();

        validateInputBudget(budget);

        return budget;
    }

    private static void validateInputBudget(String input) throws IllegalArgumentException {
        if(!Pattern.matches("^[0-9]*000$", input)) {
            throw new IllegalArgumentException(ErrMsg.VALIDATE_INPUT_BUDGET);
        }
    }
}
