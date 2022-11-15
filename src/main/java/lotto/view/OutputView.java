package lotto.view;

import static lotto.constant.Message.INPUT_MONEY;
import static lotto.constant.Message.LOTTO_GENERATED;

import java.util.List;
import lotto.Lotto;

public class OutputView {

    public static void printInputMoney() {
        System.out.println(INPUT_MONEY);
    }

    public static void printGeneratedLotto(List<Lotto> lottos) {
        System.out.println(String.format(LOTTO_GENERATED, lottos.size()));
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
