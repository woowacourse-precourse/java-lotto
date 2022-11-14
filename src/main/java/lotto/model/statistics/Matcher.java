package lotto.model.statistics;

import lotto.model.Lotto;


public interface Matcher {
    Integer getCorrectMatch(Lotto WinningNumber, Lotto IssuedNumber);
    Boolean getBonusMatch(Integer BonusNumber, Lotto IssuedNumber);
}
