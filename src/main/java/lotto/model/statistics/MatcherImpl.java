package lotto.model.statistics;

import lotto.model.Lotto;
import lotto.model.WinningNumbers;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

public class MatcherImpl implements Matcher {

    private final List<Lotto> IssuedLotto;
    private final WinningNumbers winningNumbers;
    private final BigDecimal money;
    private final Statistics statistics;

    public MatcherImpl(List<Lotto> issuedLotto, WinningNumbers winningNumbers, BigDecimal money) {
        this.IssuedLotto = issuedLotto;
        this.winningNumbers = winningNumbers;
        this.money = money;
        this.statistics = new Statistics();
        match();
    }

    @Override
    public Statistics getStatistics() {
        return this.statistics;
    }

    @Override
    public void match() {
        for (Lotto lotto : IssuedLotto) {
            Integer sameCount = getCorrectMatch(winningNumbers, lotto);
            Boolean bonusMatch = getBonusMatch(winningNumbers, lotto);
            Rank rank = Rank.of(sameCount, bonusMatch);
            if (!rank.equals(Rank.FAIL)) {
                statistics.update(rank);
            }
        }
        statistics.calculateYield(money);
    }

    private Integer getCorrectMatch(WinningNumbers winningNumber, Lotto issuedNumber) {
        List<Integer> winningNumbers = winningNumber.getWinningNumbers();
        List<Integer> issuedNumbers = issuedNumber.getNumbers();

        return (int) winningNumbers.stream()
                .filter(number -> issuedNumbers.stream().anyMatch(Predicate.isEqual(number)))
                .distinct()
                .count();
    }


    private Boolean getBonusMatch(WinningNumbers winningNumbers, Lotto issuedNumber) {
        List<Integer> numbers = issuedNumber.getNumbers();
        Integer bonusNumber = winningNumbers.getBonusNumber();
        return numbers.contains(bonusNumber);
    }


}
