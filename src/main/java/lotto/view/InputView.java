package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PAYMENT_AMOUNT = "구입금액을 입력해 주세요.";

    public static String inputPaymentAmount() {
        System.out.println(PAYMENT_AMOUNT);
        return Console.readLine();
    }
}
