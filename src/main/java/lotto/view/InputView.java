package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String LOTTO_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";

    public static String lottoPriceInput() {
        System.out.println(LOTTO_PRICE_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String winningNumbersInput() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
        return Console.readLine();
    }
}
