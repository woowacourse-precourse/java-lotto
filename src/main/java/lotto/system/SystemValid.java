package lotto.system;

import java.util.List;
import java.util.regex.Pattern;
import lotto.system.SystemValue;
import lotto.type.ErrorType;

public class SystemValid {
    public static void validateForNumber(String text, ErrorType type) {
        Pattern pattern = Pattern.compile(SystemValue.REGEX_ONLY_NUMBER);
        if (!pattern.matcher(text).matches()) {
            throw new IllegalArgumentException("[ERROR] " + type.getName() + text + " 숫자가 아닙니다.");
        }
    }

    public static void validateForWinningNumber(String text) {
        Pattern pattern = Pattern.compile(SystemValue.REGEX_WINNING_NUMBER);
        if (!pattern.matcher(text).matches()) {
            throw new IllegalArgumentException("[ERROR] 당첨번호 " + text + "가 형식이 맞지 않습니다.");
        }
    }

    public static void validateForSize(List<Integer> numbers, ErrorType type) {
        if (numbers.size() != SystemValue.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] " + type.getName() + " 입력값은 6개의 번호가 아닙니다.");
        }
    }

    public static void validateForBetween(List<Integer> numbers, ErrorType type) {
        for (int number : numbers) {
            if (SystemValue.MINIMUM_RANGE > number || number > SystemValue.MAXIMUM_RANGE) {
                throw new IllegalArgumentException("[ERROR] " + type.getName() + " 입력값은 지정된 범위의 값이 아닙니다.");
            }
        }
    }

    public static void validateForUnique(List<Integer> numbers, ErrorType type) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] " + type.getName() + " 입력값은 중복이 되면 안됩니다.");
        }
    }
}
