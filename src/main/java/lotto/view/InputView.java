package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.printer.InputPrinter.*;

import static lotto.view.printer.InputPrinter.*;

public class InputView {
    public static String inputMoneyByUser(){
        printInputMoneyMessage();
        String userMoney = Console.readLine();
        return userMoney;
    }

    public static String inputWinningNumbers(){
        printInputWinningNumbersMessage();
        String winningNumbers = Console.readLine();
        return winningNumbers;
    }

    public static String inputBonusNumber(){
        printInputBonusNumbersMessage();
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
