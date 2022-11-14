package lotto.model.statistics;

import lotto.model.Lotto;
import lotto.model.WinningNumbers;

import java.util.List;
import java.util.function.Predicate;

public class MatcherImpl implements Matcher{
    @Override
    public Integer getCorrectMatch(WinningNumbers WinningNumber, Lotto IssuedNumber) {
        List<Integer> winningNumbers = WinningNumber.getWinningNumbers();
        List<Integer> issuedNumbers = IssuedNumber.getNumbers();

        return (int) winningNumbers.stream()
                .filter(winningNumber -> issuedNumbers.stream().anyMatch(Predicate.isEqual(winningNumber)))
                .distinct()
                .count();
    }

    @Override
    public Boolean getBonusMatch(WinningNumbers winningNumbers, Lotto IssuedNumber) {
        List<Integer> numbers = IssuedNumber.getNumbers();
        Integer bonusNumber = winningNumbers.getBonusNumber();
        return numbers.contains(bonusNumber);
    }


}
