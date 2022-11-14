package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validator;

public class InputView {

    public static int askPurchaseAmount() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        Validator.isBlank(input);
        Validator.isNumber(input);
        return Integer.parseInt(input);
    }

    public static String askWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    public static String askBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }
}
