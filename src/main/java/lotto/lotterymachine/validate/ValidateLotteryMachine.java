package lotto.lotterymachine.validate;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.util.Constant;

public class ValidateLotteryMachine {
    public static final Pattern NUMBER_PATTERN = Pattern.compile(
            "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$"); // 숫자만 등장 하는지

    public static void validateOnlyNumbers(String userInput) {
        List<String> singleNumbers = Arrays.asList(userInput.split(","));
        for (String singlenumber : singleNumbers) {
            if (!NUMBER_PATTERN.matcher(singlenumber).matches()) {
                throw new IllegalArgumentException(Constant.INPUT_ERROR_MESSAGE);
            }
        }
    }

    public static void validateNumbersSize(String userInput) {
        List<String> singleNumbers = Arrays.asList(userInput.split(","));
        if (!(singleNumbers.size() == Constant.LOTTO_NUMBER_SIZE)) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE_HEAD+" 6자리 숫자가 아닙니다");
        }
    }

    public static void validateOnlyNumber(String userInput) {
        if (!NUMBER_PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException(Constant.INPUT_ERROR_MESSAGE);
        }
    }

}
