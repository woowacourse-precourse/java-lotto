package lotto.model.statistics;

import lotto.model.Lotto;

import java.util.List;
import java.util.function.Predicate;

public class MatcherImpl implements Matcher{
    @Override
    public Integer getCorrectMatch(Lotto WinningNumber, Lotto IssuedNumber) {
        List<Integer> winningNumbers = WinningNumber.getNumbers();
        List<Integer> issuedNumbers = IssuedNumber.getNumbers();

        return (int) winningNumbers.stream()
                .filter(winningNumber -> issuedNumbers.stream().anyMatch(Predicate.isEqual(winningNumber)))
                .distinct()
                .count();
    }

    @Override
    public Boolean getBonusMatch(Integer BonusNumber, Lotto IssuedNumber) {
        List<Integer> numbers = IssuedNumber.getNumbers();
        return numbers.contains(BonusNumber);
    }


}
