package lotto;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.constant.Constants.*;

public class Validator {

    public static void validateForIllegalInput(String input) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(REGEX_ONLY_NUMBER);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find()) {
            throwIllegalArgumentException(ERROR_MESSAGE + INVALID_INPUT_ERROR_MESSAGE);
        }
    }

    public static void validateForIllegalInput(String[] inputList) {
        for (int i = 0; i < inputList.length; i++) {
            if (!inputList[i].matches(REGEX_ONLY_NUMBER)) {
                throwIllegalArgumentException(ERROR_MESSAGE + INVALID_INPUT_ERROR_MESSAGE);
            }
        }
    }

    public static void validateForDuplicatedNumber(Lotto lotto, int bonusNumber) {
        if (lotto.isContained(bonusNumber)) {
            throwIllegalArgumentException(ERROR_MESSAGE + DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void validateForRange(List<Integer> WinningNumber) {
        if (!WinningNumber.stream().allMatch(num -> num >= MIN_LOTTO_NUMBER && num <= MAX_LOTTO_NUMBER)) {
            throwIllegalArgumentException(ERROR_MESSAGE + OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    public static void validateForDividedBy1000(int cost) {
        if (cost % 1000 != 0) {
            throwIllegalArgumentException(ERROR_MESSAGE + INVALID_COST_ERROR_MESSAGE);
        }
    }

    public static void throwIllegalArgumentException(String message) {
        System.out.println(message);
        throw new IllegalArgumentException(message);
    }
}
