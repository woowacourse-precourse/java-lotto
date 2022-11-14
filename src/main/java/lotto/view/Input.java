package lotto.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자에게 입력을 받는 책임을 가진 클래스
 */
public class Input {

    private static final String INPUT_LOTTO_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_NUMBER_FORMAT = "[ERROR] 올바른 숫자를 입력해 주세요.";

    public Input() {
    }

    public static int getInputPurchaseAmount() {
        System.out.println(INPUT_LOTTO_PURCHASE_AMOUNT);
        String input = Console.readLine();

        if (!isNumber(input)) {
            throw new IllegalArgumentException(ERROR_NUMBER_FORMAT);
        }

        return Integer.parseInt(input);
    }

    private static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static String getInputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);

        return Console.readLine();
    }

    public static int getInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);

        return Integer.parseInt(Console.readLine());
    }


}
