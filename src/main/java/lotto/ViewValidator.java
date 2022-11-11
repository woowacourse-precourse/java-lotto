package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ViewValidator {
    private static final String INVALID_NUMBER_TYPE_REGEX = "\\D";
    private static final int UNIT_OF_MONEY = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public void validateNumberType(String number) {
        if (Pattern.compile(INVALID_NUMBER_TYPE_REGEX).matcher(number).find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_TYPE.getMessage());
        }
    }

    public void validateUnitOf1000(String money) {
        if (Integer.parseInt(money) % UNIT_OF_MONEY != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_UNIT_OF_MONEY.getMessage());
        }
    }

    public List<Integer> getValidNumbers(String winningNumbers) {
        validateNumberCount(winningNumbers);
        return Arrays.stream(winningNumbers.split(","))
                .peek(this::validateNumberType)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void validateNumberCount(String numbers) {
        if (numbers.split(",").length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }
}
