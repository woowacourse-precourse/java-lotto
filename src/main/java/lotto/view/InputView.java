package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Parser;
import lotto.validator.InputValidator;

import java.util.List;

public class InputView {

    public static final String USER_MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static long getUserMoney() {
        printMessage(USER_MONEY_INPUT_MESSAGE);

        String money = Console.readLine();
        InputValidator.checkMoney(money);
        return Long.valueOf(money);
    }

    public static List<Integer> getWinningNumber() {
        printMessage(WINNING_NUMBER_INPUT_MESSAGE);

        String winningNumber = Console.readLine();
        return Parser.convertStringToIntegerList(winningNumber);
    }

    public static int getBonusNumber() {
        printMessage(BONUS_NUMBER_INPUT_MESSAGE);

        String bonusNumber = Console.readLine();
        InputValidator.checkBonusNumber(bonusNumber);
        return Integer.valueOf(bonusNumber);
    }

    public static void printMessage(String message){
        System.out.println(message);
    }
}
