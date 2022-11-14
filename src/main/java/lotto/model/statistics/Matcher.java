package lotto.model.statistics;

import lotto.model.Lotto;
import lotto.model.WinningNumbers;


public interface Matcher {
    Integer getCorrectMatch(WinningNumbers winningNumbers, Lotto IssuedNumber);
    Boolean getBonusMatch(WinningNumbers winningNumbers, Lotto IssuedNumber);
}
