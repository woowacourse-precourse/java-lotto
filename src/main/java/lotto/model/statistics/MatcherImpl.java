package lotto.model.statistics;

import lotto.model.Lotto;
import lotto.model.WinningNumbers;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

public class MatcherImpl implements Matcher{

    private final List<Lotto> IssuedLotto;
    private final WinningNumbers winningNumbers;
    private final BigDecimal money;
    private final Statistics statistics;

    public MatcherImpl(List<Lotto> issuedLotto, WinningNumbers winningNumbers, BigDecimal money){
        this.IssuedLotto = issuedLotto;
        this.winningNumbers = winningNumbers;
        this.money = money;
        this.statistics = new Statistics();
    }
    @Override
    public Statistics getStatistics() {
        return this.statistics;
    }

    @Override
    public void match(){
        for (Lotto lotto : IssuedLotto) {
            Integer sameCount = getCorrectMatch(winningNumbers, lotto);
            Boolean bonusMatch = getBonusMatch(winningNumbers, lotto);
            Rank rank = Rank.of(sameCount, bonusMatch);
            statistics.update(rank);
        }
        statistics.calculateYield(money);
    }

    private Integer getCorrectMatch(WinningNumbers WinningNumber, Lotto IssuedNumber) {
        List<Integer> winningNumbers = WinningNumber.getWinningNumbers();
        List<Integer> issuedNumbers = IssuedNumber.getNumbers();

        return (int) winningNumbers.stream()
                .filter(winningNumber -> issuedNumbers.stream().anyMatch(Predicate.isEqual(winningNumber)))
                .distinct()
                .count();
    }


    private Boolean getBonusMatch(WinningNumbers winningNumbers, Lotto IssuedNumber) {
        List<Integer> numbers = IssuedNumber.getNumbers();
        Integer bonusNumber = winningNumbers.getBonusNumber();
        return numbers.contains(bonusNumber);
    }


}
