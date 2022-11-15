package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.UserLotto;

import java.util.List;

import static lotto.constant.MessageConstant.MESSAGE_OUTPUT_COUNT;
import static lotto.constant.MessageConstant.MESSAGE_OUTPUT_WIN_STATISTICS;

public class OutputView {
    public static void printBlankLine() {
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
        printBlankLine();
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println(MESSAGE_OUTPUT_WIN_STATISTICS);
        System.out.println(lottoResult.getLottoResultString());
    }
}
