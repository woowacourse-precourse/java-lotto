package lotto.service;

import camp.nextstep.edu.missionutils.Console;

public class InputService {

    public static String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public String readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }

}
