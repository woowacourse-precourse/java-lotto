package lotto.view;

import lotto.domain.Lotto;
import lotto.type.TextType;

public class OutputView {

    public static void showLottoCount(int count) {
        System.out.println("\n" + count + TextType.LOTTO_COUNT_MESSAGE.getText());
    }

    public static void showLottoNumber(Lotto lotto) {
        System.out.println(lotto.getNumbers().toString());
    }
}
