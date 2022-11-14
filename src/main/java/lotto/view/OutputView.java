package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.UserLotto;

import java.util.List;

import static lotto.constant.MessageConstant.MESSAGE_OUTPUT_COUNT;

public class OutputView {
    private static void printBlankLine() {
        System.out.println();
    }

    public static void printCountOfPurchasedLotto(UserLotto userLotto) {
        int countOfPurchasedLotto = userLotto.countOfPurchasedLotto();
        printBlankLine();
        System.out.println(countOfPurchasedLotto + MESSAGE_OUTPUT_COUNT);
    }

    public static void printSortedLottos(UserLotto userLotto) {
        List<Lotto> lottos = userLotto.getUserLottos();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
