package view;

import camp.nextstep.edu.missionutils.Console;
import model.Money;

public class InputView {
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public static Money inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT);

        return new Money(Integer.parseInt(Console.readLine()));
    }
}