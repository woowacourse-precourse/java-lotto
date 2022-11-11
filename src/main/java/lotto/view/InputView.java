package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.dto.PaymentAmountDto;

public class InputView {

    private static final String PAYMENT_AMOUNT = "구입금액을 입력해 주세요.";

    public static PaymentAmountDto inputPaymentAmount() {
        System.out.println(PAYMENT_AMOUNT);
        return new PaymentAmountDto(Console.readLine());
    }
}
