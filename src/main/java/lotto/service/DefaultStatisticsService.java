package lotto.service;

import java.util.Map;
import java.util.Objects;
import lotto.domain.BonusNumber;
import lotto.domain.Grade;
import lotto.domain.IssuedLotto;
import lotto.domain.StatResult;
import lotto.domain.WinningNumber;

public class DefaultStatisticsService implements StatisticsService {

    @Override
    public StatResult compileStatistics(IssuedLotto issuedLotto, WinningNumber winningNumber, BonusNumber bonusNumber) {
        Map<Grade, Integer> result = compile(issuedLotto, winningNumber, bonusNumber);

        return new StatResult(issuedLotto.getPrice(), result);
    }

    private Map<Grade, Integer> compile(IssuedLotto issuedLotto, WinningNumber winningNumber, BonusNumber bonusNumber) {
        Map<Grade, Integer> statResult = Grade.getAllGrades();

        issuedLotto.getIssuedLotto()
                   .stream()
                   .map(lotto -> lotto.getLottoResult(winningNumber.getNumbers(), bonusNumber.getNumber()))
                   .map(lottoResult -> Grade.getGrade(lottoResult.getCorrectCount(), lottoResult.isHavingBonusNumber()))
                   .filter(Objects::nonNull)
                   .forEach(grade -> statResult.put(grade, statResult.get(grade) + 1));

        return statResult;
    }

}
