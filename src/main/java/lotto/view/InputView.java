package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private InputView() {
    }

    public static String purchaseInputMessage() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return readLine();
    }

    public static String winningNumberInputMessage() {
        System.out.println(INPUT_WINNING_NUMBER);
        return readLine();
    }

    public static String bonusNumberInputMessage() {
        System.out.println(INPUT_BONUS_NUMBER);
        return readLine();
    }
}
