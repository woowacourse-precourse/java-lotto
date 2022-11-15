package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.UserLotto;

import java.util.List;

import static lotto.constant.MessageConstant.*;

public class OutputView {
    public void printBlankLine() {
        System.out.println();
    }

    public void printCountOfPurchasedLotto(UserLotto userLotto) {
        int countOfPurchasedLotto = userLotto.countOfPurchasedLotto();
        printBlankLine();
        System.out.println(countOfPurchasedLotto + MESSAGE_OUTPUT_COUNT);
    }

    public void printSortedLottos(UserLotto userLotto) {
        List<Lotto> lottos = userLotto.getUserLottos();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        printBlankLine();
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println(MESSAGE_OUTPUT_WIN_STATISTICS);
        System.out.println(lottoResult.getLottoResultString());
    }

    public void printLottoProfit(LottoResult lottoResult) {
        System.out.printf(MESSAGE_OUTPUT_TOTAL_PROFIT,lottoResult.getTotalProfitRate());
    }
}
