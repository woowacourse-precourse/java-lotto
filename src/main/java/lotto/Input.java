package lotto;

import camp.nextstep.edu.missionutils.Console;

import javax.swing.*;
import java.util.regex.Pattern;

public class Input {
    private static final String regexGroup = "([1-9]|[1-3][0-9]|4[0-5])";

    public Input() {

    }

    private static String input() {
        return Console.readLine();
    }

    //로또 구입 금액 입력
    public static String inputBudget() throws IllegalArgumentException {
        String budget = input();

        validateInputBudget(budget);

        return budget;
    }

    private static void validateInputBudget(String input) throws IllegalArgumentException {
        if (!Pattern.matches("^[0-9]*000$", input)) {
            throw new IllegalArgumentException(ErrMsg.VALIDATE_INPUT_BUDGET);
        }
    }

    //로또 당첨
    public static String inputPrize() throws IllegalArgumentException {
        String prize = input();

        validateInputPrize(prize);

        return prize;
    }

    private static void validateInputPrize(String prize) throws IllegalArgumentException {
        String pattern = "^(" + regexGroup + ",? ){5}" + regexGroup;

        if (!Pattern.matches(pattern, prize)) {
            throw new IllegalArgumentException(ErrMsg.VALIDATE_INPUT_PRIZE_NUM);
        }
    }

    public static String inputBonus() throws IllegalArgumentException {
        String bonus = input();

        validateInputBonus(bonus);

        return bonus;
    }

    private static void validateInputBonus(String bonus) throws IllegalArgumentException {
        if (!Pattern.matches("^" + regexGroup, bonus)) {
            throw new IllegalArgumentException(ErrMsg.VALIDATE_BONUS_NUM_ONE);
        }
    }
}
