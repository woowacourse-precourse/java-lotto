package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.NumberException;
import lotto.domain.User;

public class GameInput {

    public static void getUserMoneyInput() {
        GameOutput.printMoneyInput();
        String userInput = Console.readLine();
        NumberException.checkUserInputMoney(userInput);
        User.setUserInputMoney(userInput);
        User.setLottoAmount();
    }

    public static void getUserNumberInput() {
        GameOutput.printNumberInput();
        String userInput = Console.readLine();
        NumberException.checkUserInputNumber(userInput);
        User.setUserInputNumber(userInput);
    }

    public static void getUserBonusNumberInput() {
        GameOutput.printBonusNumberInput();
        String userInput = Console.readLine();
        User.setUserInputBonusNumber(userInput);
    }
}
