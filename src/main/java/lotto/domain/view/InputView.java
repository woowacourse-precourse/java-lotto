package lotto.domain.view;

import lotto.domain.lotto.domain.Lotto;
import lotto.global.util.Util;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String getInputMoney() {
        System.out.println(INPUT_MONEY);
        return Util.input();
    }

    public static int getInputBonusNumber(Lotto prizeLotto) {
        OutputView.enter();
        System.out.println(INPUT_BONUS_NUMBER);
        return Util.inputBonusNumber(prizeLotto);
    }
}
