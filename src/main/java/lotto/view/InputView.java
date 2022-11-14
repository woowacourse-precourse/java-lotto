package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Parser;
import lotto.validator.InputValidator;

import java.util.List;

public class InputView {

    public static final String USER_MONEY_INPUT_MESSAGE = "구입 금액을 입력하세요: ";
    public static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력하세요: ";
    public static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력하세요: ";

    public static long getUserMoney() {
        System.out.print(USER_MONEY_INPUT_MESSAGE);

        String money = Console.readLine();
        InputValidator.checkDigit(money);
        return Long.valueOf(money);
    }

    public static List<Integer> getWinningNumber() {
        System.out.print(WINNING_NUMBER_INPUT_MESSAGE);

        String winningNumber = Console.readLine();
        return Parser.convertStringToIntegerList(winningNumber);
    }

    public static int getBonusNumber() {
        System.out.print(BONUS_NUMBER_INPUT_MESSAGE);
        String bonusNumber = Console.readLine();

        InputValidator.checkDigit(bonusNumber);
        return Integer.valueOf(bonusNumber);
    }
}
