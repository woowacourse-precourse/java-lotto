package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.IssuedLotto;
import lotto.domain.StatResult;
import lotto.domain.WinningNumber;

public interface StatisticsService {

    StatResult compileStatistics(IssuedLotto issuedLotto, WinningNumber winningNumber, BonusNumber bonusNumber);

}
