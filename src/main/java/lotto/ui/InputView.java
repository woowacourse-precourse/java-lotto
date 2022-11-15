package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {
    private static final String MONEY_AMOUNT_PATTERN = "^[1-9]+\\d+$";
    private static final String WINNING_NUMBER_PATTERN = "^[1-9]\\d*,[1-9]\\d*,[1-9]\\d*,[1-9]\\d*,[1-9]\\d*,[1-9]\\d*$";
    private static final String BONUS_NUMBER_PATTERN = "^[1-9]\\d?$";

    private static final String MONEY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private InputView() {
    }

    public static long money() {
        System.out.println(MONEY_AMOUNT_MESSAGE);
        String input = readLine();
        validatePurchaseAmount(input);
        return Long.parseLong(input);
    }

    public static String winningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        String input = readLine();
        validateWinningNumber(input);
        return input;
    }

    public static int bonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String input = readLine();
        validateBonusNumber(input);
        return Integer.parseInt(input);
    }

    private static void validatePurchaseAmount(String input) {
        if (!input.matches(MONEY_AMOUNT_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    private static void validateWinningNumber(String input) {
        if (!input.matches(WINNING_NUMBER_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] ,로 구분되는 6개의 숫자를 입력해주세요.");
        }
    }

    private static void validateBonusNumber(String input) {
        if (!input.matches(BONUS_NUMBER_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }
}
