package lotto.model.statistics;

import lotto.model.Lotto;
import lotto.model.WinningNumbers;


public interface Matcher {
    void match();
    Statistics getStatistics();
}
