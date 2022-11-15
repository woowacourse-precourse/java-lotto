package lotto;

import java.util.List;

public class LottoCompareContext {

    private static String lookUpAllLotto(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            CorrectType correctType = winningLotto.compareNumber(lotto);
            WinningStatistics.plus(correctType);
        }

        return WinningStatistics.printlnResultString();
    }
}
