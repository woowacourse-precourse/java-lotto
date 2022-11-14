package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_MONEY = "구입금액을 입력해 주세요.";

    public String purchaseInput() {
        System.out.println(PURCHASE_MONEY);
        return Console.readLine();
    }
}
