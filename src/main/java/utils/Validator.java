package utils;

import constants.LottoConstants;
import constants.UIConstants;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Validator {

    private static final Pattern REGEX = Pattern.compile("[0-9]+");

    public static void checkBonusNumberIsValid(String userInput, List<Integer> winNumbers) {
        if (!userInput.matches(REGEX.pattern())) {
            throw new IllegalArgumentException(UIConstants.INVALID_BONUS_INPUT_FORMAT);
        }

        int bonusNumber = Integer.parseInt(userInput);
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(UIConstants.DUPLICATED_BONUS_NUMBER);
        }

        if (bonusNumber < LottoConstants.MIN_LOTTO_VALUE ||
                bonusNumber > LottoConstants.MAX_LOTTO_VALUE) {
            throw new IllegalArgumentException(UIConstants.INVALID_RANGE_BONUS_NUMBER);
        }
    }
}
