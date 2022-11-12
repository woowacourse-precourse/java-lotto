package lotto.domain;

import lotto.exception.InputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class UserLotto {

    private final String REG_XP_LOTTO = "^[0-9,]+$";

    private final String SPLIT_STANDARD = ",";

    private final List<Integer> winNumbers;
    private final int bonusNumber;

    public UserLotto(String winNumbers, String bonusNumber) {
        isDigitAndSplitByStandard(winNumbers);
        isValidLottoCount(winNumbers);
        isValidLottoRange(winNumbers);
        hasNotDuplicateLotto(winNumbers);
        isValidBonusLottoRange(bonusNumber);
        this.winNumbers = List.copyOf(mapToList(winNumbers));
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void isDigitAndSplitByStandard(String winNumbers) {
        if (!winNumbers.matches(REG_XP_LOTTO)) {
            throw new IllegalArgumentException(InputException.INPUT_INVALID_FORM.message());
        }
    }

    private void isValidLottoCount(String winNumbers) {
        if (Arrays.stream(winNumbers.split(SPLIT_STANDARD)).count() != 6) {
            throw new IllegalArgumentException(InputException.INPUT_INVALID_DIGIT_COUNT.message());
        }
    }

    private void isValidLottoRange(String winNumbers) {
        long count = Arrays.stream(winNumbers.split(SPLIT_STANDARD))
                .map(Integer::parseInt)
                .filter(x -> 1 <= x && x <= 45)
                .count();

        if (count != 6) {
            throw new IllegalArgumentException(InputException.INPUT_INVALID_DIGIT_RANGE.message());
        }
    }

    private void hasNotDuplicateLotto(String winNumbers) {
        if (Arrays.stream(winNumbers.split(SPLIT_STANDARD)).distinct().count() != 6) {
            throw new IllegalArgumentException(InputException.INPUT_HAS_NOT_DUPLICATE_DIGIT.message());
        }
    }

    private List<Integer> mapToList(String winNumbers) {
        return Arrays.stream(winNumbers.split(SPLIT_STANDARD))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private void isValidBonusLottoRange(String bonusNumber) {
        if (bonusNumber.length() != 1 || !bonusNumber.matches(SPLIT_STANDARD)
                || ( 1 > Integer.parseInt(bonusNumber) && Integer.parseInt(bonusNumber) > 45 )) {
            throw new IllegalArgumentException(InputException.INPUT_INVALID_BONUS_LOTTO.message());
        }
    }
}
