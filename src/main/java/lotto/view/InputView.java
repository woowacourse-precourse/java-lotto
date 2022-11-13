package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.utils.ViewMessages.*;

public class InputView {
    private InputView() {
    }

    public static String money() {
        System.out.println(INPUT_MONEY);
        return Console.readLine();
    }

    public static String winningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public static String bonusBallNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
