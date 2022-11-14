package lotto;

import constants.LottoConstants;
import constants.UIConstants;
import user.BonusNumber;
import user.WinNumber;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUM) {
            throw new IllegalArgumentException(UIConstants.INVALID_LOTTO_COUNT_NUMBERS);
        }
        Set<Integer> noDuplicatedNumbers = numbers.stream().collect(Collectors.toSet());
        if (noDuplicatedNumbers.size() != LottoConstants.LOTTO_NUM) {
            throw new IllegalArgumentException(UIConstants.DUPLICATED_LOTTO_NUMBERS);
        }
        for (int number : noDuplicatedNumbers) {
            if (number < LottoConstants.MIN_LOTTO_VALUE ||
                    number > LottoConstants.MAX_LOTTO_VALUE) {
                throw new IllegalArgumentException(UIConstants.INVALID_RANGE_LOTTO_NUMBERS);
            }
        }
    }

    public Wins countMatchingNumber(WinNumber winNumber, BonusNumber bonusNumber) {
        List<Integer> winNumbers = winNumber.getWinNumber();
        int matchingCount = 0;

        for (int number : numbers) {
            if (winNumbers.contains(number)) {
                matchingCount++;
            }
        }

        boolean isBonusMatched = false;
        if (matchingCount == LottoConstants.BONUS_MATCH_LOTTO_NUM) {
            isBonusMatched = numbers.contains(bonusNumber.getBonusNumber());
        }

        return Wins.getWins(matchingCount, isBonusMatched);
    }

    @Override
    public String toString() {
        return numbers.stream().sorted().collect(Collectors.toList()).toString();
    }
}
