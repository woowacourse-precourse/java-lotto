package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String LOTTO_PURCHASE_PRICE_COMMENT = "구입금액을 입력해 주세요.";

    public static int getLottoPrice() {
        System.out.println(LOTTO_PURCHASE_PRICE_COMMENT);
        return Integer.parseInt(Console.readLine());
    }
}
