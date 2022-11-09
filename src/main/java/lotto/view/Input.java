package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

public class Input {

    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public Money inputAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
        return readLindToAmount();
    }

    private static Money readLindToAmount() {
        return new Money(Console.readLine());
    }

}
