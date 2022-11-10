package lotto.domain.view;

import lotto.domain.view.util.Util;

public class InputView {
    private static final String INPUT_PRICE = "구입금액을 입력해 주세요.";

    public static String getInputPrice() {
        System.out.println(INPUT_PRICE);
        return Util.input();
    }

}
