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
        String[] split = winningNumbers.split(",");
        validWinningNumbers(winningNumbers);
        validIsDigit(bonusNumber);
        this.winningNumbers = Stream.of(split).map(Integer::parseInt).collect(Collectors.toList());
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

    private static void validWinningNumbers(String winningNumbers) {
        for (String num : winningNumbers.split(",")) {
            validIsDigit(num);
            validNumberRange(Integer.parseInt(num));
        }
    }

    private static void validIsDigit(String num) {
        try {
            Integer.parseInt(num);
        } catch (IllegalArgumentException e) {
            System.out.println(NOT_NUMBER);
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    private static void validNumberRange(int num) {
        if (num < LOTTO_NUMBER_MIN || num > LOTTO_NUMBER_MAX) {
            System.out.println(NOT_LOTTO_NUMBER_RANGE);
            throw new IllegalArgumentException(NOT_LOTTO_NUMBER_RANGE);
        }
    }


}
