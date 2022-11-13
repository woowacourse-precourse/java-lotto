package lotto.template;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.validator.MoneyValidator;
import lotto.utils.validator.NumberValidator;

public class Input {
    public static int insertMoney() {
        String input = readAfterPrint("구입금액을 입력해 주세요.");
        return parseMoney(input);
    }

    public static void insertWinningNumbers() {
        String input = readAfterPrint("당첨 번호를 입력해 주세요.");
    }

    public static void insertBonusNumber() {
        String input = readAfterPrint("보너스 번호를 입력해 주세요.");
    }

    private static String readAfterPrint(String out) {
        System.out.println(out);
        return Console.readLine();
    }

    private static int parseMoney(String input) {
        NumberValidator.checkNaturalNumber(input);
        return Integer.parseInt(input);
    }
}
