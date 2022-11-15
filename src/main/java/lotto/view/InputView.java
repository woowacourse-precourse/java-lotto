package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.view.printer.InputPrinter.printInputBonusNumbersMessage;
import static lotto.view.printer.InputPrinter.printInputMoneyMessage;

public class InputView {
    public static String inputMoneyByUser() {
        printInputMoneyMessage();
        String userMoney = Console.readLine();
        return userMoney;
    }

    public static String inputBonusNumber() {
        printInputBonusNumbersMessage();
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
