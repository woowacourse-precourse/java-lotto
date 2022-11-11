package lotto;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.constant.Constants.*;

public class Validator {

    public static void validateForIllegalInput(String input) {
        Pattern pattern = Pattern.compile(REGEX_ONLY_NUMBER);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
        }
    }

    public static void validateForIllegalInput(String[] inputList) {
        for (int i = 0; i < inputList.length; i++) {
            if (!inputList[i].matches(REGEX_ONLY_NUMBER)) {
                throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
            }
        }
    }

    public static void validateForDuplicatedNumber(Lotto lotto, int bonusNumber) {
        if (lotto.isContained(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void validateForRange(List<Integer> WinningNumber) {
        if (!WinningNumber.stream().allMatch(num -> num >= MIN_LOTTO_NUMBER && num <= MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    public static void validateForDividedBy1000(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_COST_ERROR_MESSAGE);
        }
    }
}
