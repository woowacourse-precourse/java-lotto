package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.IntegerConvertor;

import static lotto.utils.ErrorMessages.MONEY_NOT_INTEGER;
import static lotto.utils.ViewMessages.*;
import static lotto.view.OutputView.printLine;

public class InputView {
    private InputView() {
    }

    public static int inputMoney() {
        System.out.println(INPUT_MONEY);
        return IntegerConvertor.toInteger(Console.readLine(), MONEY_NOT_INTEGER);
    }

    public static String inputWinningNumbers() {
        printLine();
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        printLine();
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
