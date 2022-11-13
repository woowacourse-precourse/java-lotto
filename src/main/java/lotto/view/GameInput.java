package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.mainframe.User;

public class GameInput {

    public static void getUserMoneyInput() {
        GameOutput.printMoneyInput();
        String userInput = Console.readLine();
        //예외처리
        User.setUserInputMoney(userInput);
        User.setLottoAmount();
    }

    public static void getUserNumberInput() {
        GameOutput.printNumberInput();
        String userInput = Console.readLine();
        //예외처리
        User.setUserInputNumber(userInput);
    }

    public static void getUserBonusNumberInput() {
        GameOutput.printBonusNumberInput();
        String userInput = Console.readLine();
        //예외처리
        User.setUserInputBonusNumber(userInput);
    }
}
