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
        isValidLottoRange(winNumbers);
        this.winNumbers = List.copyOf(mapToList(winNumbers));
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void isDigitAndSplitByStandard(String winNumbers) {
        if (!winNumbers.matches(REG_XP_LOTTO)) {
            throw new IllegalArgumentException(InputException.INPUT_INVALID_FORM.message());
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

    private List<Integer> mapToList(String winNumbers) {
        return Arrays.stream(winNumbers.split(SPLIT_STANDARD))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
