package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final static String ENTER_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String ENTER_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String ENTER_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final static String COMMA = ",";

    public static final String price() {
        System.out.println(ENTER_PURCHASE_PRICE_MESSAGE);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public static final String[] winningNumbers() {
        System.out.println(ENTER_WINNING_NUMBERS_MESSAGE);
        String input = Console.readLine();
        System.out.println();
        return input.split(COMMA);
    }

    public static final String bonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
