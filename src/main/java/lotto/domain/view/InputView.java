package lotto.domain.view;

import lotto.global.util.Util;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";

    public static String getInputMoney() {
        System.out.println(INPUT_MONEY);
        return Util.input();
    }

}
