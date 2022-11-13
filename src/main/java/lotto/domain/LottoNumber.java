package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static constant.Constant.*;
import static constant.ErrorMessage.*;

public class LottoNumber {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoNumber(String winningNumbers, String bonusNumber) {
        List<String> splitWinningNumbers = split(winningNumbers);
        validWinningNumbers(splitWinningNumbers);
        validIsDigit(bonusNumber);
        this.winningNumbers = convertStringToInteger(splitWinningNumbers);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public MatchCount getMatchResult(Lotto lotto) {
        int match = 0;
        int bonusMatch = 0;
        for (int idx = INITIAL_NUMBER; idx < LOTTO_SIZE; idx++) {
            if (lotto.getNumbers().contains(winningNumbers.get(idx))) {
                match++;
            }
        }
        if (lotto.getNumbers().contains(bonusNumber)) {
            bonusMatch++;
        }
        return new MatchCount(match, bonusMatch);
    }

    private List<String> split(String winningNumbers) {
        return Stream.of(winningNumbers.split(","))
                .map(num -> num.replaceAll(" ", ""))
                .collect(Collectors.toList());
    }

    private List<Integer> convertStringToInteger(List<String> numbers) {
        return numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validWinningNumbers(List<String> numbers) {
        for (String num : numbers) {
            validIsDigit(num);
            validNumberRange(Integer.parseInt(num));
        }
    }

    private void validIsDigit(String num) {
        try {
            Integer.parseInt(num);
        } catch (IllegalArgumentException e) {
            System.out.println(NOT_NUMBER);
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    private void validNumberRange(int num) {
        if (num < LOTTO_NUMBER_MIN || num > LOTTO_NUMBER_MAX) {
            System.out.println(NOT_LOTTO_NUMBER_RANGE);
            throw new IllegalArgumentException(NOT_LOTTO_NUMBER_RANGE);
        }
    }
}
