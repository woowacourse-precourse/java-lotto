package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String LOTTO_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public static String lottoPriceInput() {
        System.out.println(LOTTO_PRICE_INPUT_MESSAGE);
        return Console.readLine();
    }
}
