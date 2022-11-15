package lotto.domain;

import java.util.List;

public interface WinningNumbers {
    WinningNumbersImple generateFromRawValues(List<Integer> mainNumbers, Integer bonus);
    boolean isBonusMatchedIn(Lotto lotto);
    int countWinningLottoNumbersMatchedIn(Lotto lotto);

}
