package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoException;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static int inputMoney() {
        System.out.println(INPUT_MONEY);
        String moneyTypeString = Console.readLine();
        int money = Integer.parseInt(moneyTypeString);
        return money;
    }

    public static String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER);
        String winningNumbers = Console.readLine();
        System.out.println();
        return winningNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String StringBonusNumber = Console.readLine();
        System.out.println();
        int bonusNumber = Integer.parseInt(StringBonusNumber);
        return bonusNumber;
    }
}
