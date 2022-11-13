package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.utils.ViewMessages.*;

public class InputView {
    private InputView() {
    }

    public static String amount() {
        System.out.println(BUY_AMOUNT);
        return Console.readLine();
    }

    public static String winningNumbers() {
        System.out.println(WINNING_NUMBER);
        return Console.readLine();
    }

    public static String bonusBallNumber() {
        System.out.println(BONUS_NUMBER_NUMBER);
        return Console.readLine();
    }
}
