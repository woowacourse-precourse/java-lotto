package lotto.domain;

import lotto.exception.InputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class UserLotto {

    private final String REG_XP_LOTTO = "^[1-45,]+$";
    private final String SPLIT_STANDARD = ",";

    private final List<Integer> winNumbers;
    private final int bonusNumber;

    public UserLotto(String winNumbers, String bonusNumber) {
        isValidRangeAndSplitByStandard(winNumbers);
        this.winNumbers = List.copyOf(mapToList(winNumbers));
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void isValidRangeAndSplitByStandard(String winNumbers) {
        if (!winNumbers.matches(REG_XP_LOTTO)) {
            throw new IllegalArgumentException(InputException.INPUT_INVALID_DIGIT_RANGE.message());
        }
    }

    private List<Integer> mapToList(String winNumbers) {
        return Arrays.stream(winNumbers.split(SPLIT_STANDARD))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
