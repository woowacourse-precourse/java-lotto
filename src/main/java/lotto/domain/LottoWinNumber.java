package lotto.domain;

import java.util.Set;

import static lotto.domain.LottoSetting.*;
import static lotto.exception.LottoWinNumberExceptionMessage.*;

public class LottoWinNumber {
    private final Set<Integer> winNumbers;
    private final Integer bonusNumber;

    public LottoWinNumber(Set<Integer> winNumbers, Integer bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
        validateWinNumberSize();
        validateNumberRange();
        validateBonusNumberDuplicated();
    }

    public LottoWin compareWith(Lotto lotto) {
        int matchedNumberCount = countMatchedNumbers(lotto);
        int matchedBonusCount = matchedBonusNumber(lotto);
        return LottoWin.of(matchedNumberCount, matchedBonusCount);
    }

    private int countMatchedNumbers(Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(winNumbers::contains)
                .count();
    }

    private int matchedBonusNumber(Lotto lotto) {
        boolean isBonusMatched = lotto.getNumbers()
                .stream()
                .anyMatch(lottoNumber -> lottoNumber.intValue() == this.bonusNumber.intValue());

        if (isBonusMatched) {
            return 1;
        }
        return 0;
    }

    private void validateWinNumberSize() {
        if (winNumbers.size() != LOTTO_NUMBER_COUNT.getSetting()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_WRONG_SIZE.getMessage());
        }
    }

    private void validateNumberRange() {
        boolean validateWinNumberResult = winNumbers.stream()
                .anyMatch(number ->
                        LOTTO_MIN_NUMBER.getSetting() > number || number > LOTTO_MAX_NUMBER.getSetting());

        boolean validateBonusNumberResult =
                LOTTO_MIN_NUMBER.getSetting() > bonusNumber || bonusNumber > LOTTO_MAX_NUMBER.getSetting();

        if (validateWinNumberResult || validateBonusNumberResult) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OVER_RANGE.getMessage());
        }
    }

    private void validateBonusNumberDuplicated() {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED.getMessage());
        }
    }
}
