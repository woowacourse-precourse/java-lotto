package lotto.domain;

import static lotto.constant.SystemValue.LOTTERY_NUMBERS_SIZE;
import static lotto.constant.SystemValue.MAXIMUM_LOTTERY_NUMBER;
import static lotto.constant.SystemValue.MINIMUM_LOTTERY_NUMBER;

import java.util.List;
import java.util.regex.Pattern;
import lotto.util.TypeConverter;

public class WinningLotto {

    public static final String WINNING_NUMBERS_SIZE_ERROR = "당첨 번호는 6자리여야 합니다";
    public static final String WINNING_NUMBERS_RANGE_ERROR = "당첨 번호는 1부터 45까지의 수로 이루어져야 합니다";
    public static final String WINNING_NUMBERS_FORMAT_ERROR = "당첨 번호는 1,2,3,4,5,6 과 같은 형식이어야 합니다";
    public static final String WINNING_NUMBERS_CONFLICT_ERROR = "당첨 번호에 중복이 포함될 수 없습니다";
    private final List<Integer> numbers;

    public WinningLotto(String number) {
        validate(number);
        this.numbers = TypeConverter.toIntegerListByComma(number);
    }

    private void validate(String number) {
        checkFormatValid(number);
        checkSizeValid(number);
        checkConflictValid(number);
        checkRangeValid(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static void checkFormatValid(String winningNumber) {
        boolean isFormat = Pattern.matches("^[0-9,]*$", winningNumber); // TODO: ,, 도 안되게!!
        if (!isFormat) {
            throw new IllegalArgumentException(WINNING_NUMBERS_FORMAT_ERROR);
        }
    }

    public static void checkSizeValid(String winningNumber) {
        List<String> winningNumbers = TypeConverter.toStringListByComma(winningNumber);
        boolean isSize = winningNumbers.size() == LOTTERY_NUMBERS_SIZE;
        if (!isSize) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SIZE_ERROR);
        }
    }

    public static void checkConflictValid(String winningNumber) {
        List<Integer> winningNumbers = TypeConverter.toIntegerListByComma(winningNumber);
        boolean isConflict = winningNumbers.stream()
                .distinct()
                .count() == LOTTERY_NUMBERS_SIZE;
        if (!isConflict) {
            throw new IllegalArgumentException(WINNING_NUMBERS_CONFLICT_ERROR);
        }
    }

    public static void checkRangeValid(String winningNumber) {
        List<Integer> winningNumbers = TypeConverter.toIntegerListByComma(winningNumber);
        boolean isRange = winningNumbers.stream()
                .filter(number -> MINIMUM_LOTTERY_NUMBER <= number
                        && number <= MAXIMUM_LOTTERY_NUMBER)
                .count() == LOTTERY_NUMBERS_SIZE;
        if (!isRange) {
            throw new IllegalArgumentException(WINNING_NUMBERS_RANGE_ERROR);
        }
    }
}
