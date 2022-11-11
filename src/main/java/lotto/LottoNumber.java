package lotto;

import java.util.ArrayList;
import java.util.List;

import static constant.ErrorMessage.*;
import static constant.Constant.*;

public class LottoNumber {
    private static List<Integer> winningNumbers = new ArrayList<>();
    private static int bonusNumber;

    public LottoNumber(String winningNumbers, String bonusNumber) {
        for (String num : winningNumbers.split(",")) {
            validLottoNumber(num);
            validNumberRange(Integer.parseInt(num));
            this.winningNumbers.add(Integer.parseInt(num));
        }
        validLottoNumber(bonusNumber);
        validNumberRange(Integer.parseInt(bonusNumber));
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validLottoNumber(String numbers) {
        if (numbers.equals(EMPTY)) {
            System.out.println(NOT_NUMBER);
            throw new IllegalArgumentException(NOT_NUMBER);
        }

        for (int i = INITIAL_NUMBER; i < numbers.length(); i++) {
            if (!Character.isDigit(numbers.charAt(i))) {
                System.out.println(NOT_NUMBER);
                throw new IllegalArgumentException(NOT_NUMBER);
            }
        }
    }

    private void validNumberRange(int num) {
        if (num < LOTTO_NUMBER_MIN || num > LOTTO_NUMBER_MAX) {
            System.out.println(NOT_LOTTO_NUMBER_RANGE);
            throw new IllegalArgumentException(NOT_LOTTO_NUMBER_RANGE);
        }
    }

    public static MatchCount getMatchResult(Lotto lotto) {
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
}
