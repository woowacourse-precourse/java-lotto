package lotto.domain;

import lotto.common.Constant;
import lotto.exception.InputException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class UserLotto {

    private final List<Integer> winNumbers;

    private final int bonusNumber;

    public UserLotto(List<Integer> winNumbers, int bonusNumber) {
        validate(winNumbers, bonusNumber);
        this.winNumbers = List.copyOf(winNumbers);
        this.bonusNumber = bonusNumber;
    }

    public int findBonusNumberWinCount(List<Integer> lotto) {
        return (int) IntStream.range(0, Constant.LOTTO_SIZE)
                .filter(i -> lotto.get(i).equals(bonusNumber))
                .count();
    }

    private void validate(List<Integer> winNumbers, int bonusNumber) {
        isValidLottoCount(winNumbers);
        isValidLottoRange(winNumbers);
        hasNotDuplicateLotto(winNumbers);
        isValidBonusLottoRange(bonusNumber);
    }

    private void isValidLottoCount(List<Integer> winNumbers) {
        if (winNumbers.size() != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(InputException.LOTTO_INVALID_COUNT.message());
        }
    }

    private void isValidLottoRange(List<Integer> winNumbers) {
        long count = winNumbers.stream()
                .filter(num -> Constant.MIN_LOTTO_RANGE <= num && num <= Constant.MAX_LOTTO_RANGE)
                .count();

        if (count != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(InputException.LOTTO_INVALID_RANGE.message());
        }
    }

    private void hasNotDuplicateLotto(List<Integer> winNumbers) {
        long nonDuplicateCount = winNumbers.stream()
                .distinct()
                .count();

        if (nonDuplicateCount != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(InputException.LOTTO_DUPLICATE_DIGIT.message());
        }
    }

    private void isValidBonusLottoRange(int bonusNumber) {
        if (Constant.MIN_LOTTO_RANGE > bonusNumber || bonusNumber > Constant.MAX_LOTTO_RANGE) {
            throw new IllegalArgumentException(InputException.BONUS_LOTTO_INVALID_FORM.message());
        }
    }

    public List<Integer> getLotto() {
        return new ArrayList<>(winNumbers);
    }
}
