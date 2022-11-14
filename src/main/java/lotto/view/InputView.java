package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.utils.ViewMessages.*;

public class InputView {
    private InputView() {
    }

    public static String inputMoney() {
        System.out.println(INPUT_MONEY);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
