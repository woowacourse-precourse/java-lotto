package lotto.exception;

import lotto.status.lotto.LottoStatus;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 ";
    private static final String LENGTH_EXCEPTION_MESSAGE = " 자리의 수만 가능합니다.";
    private static final String RANGE_EXCEPTION_MESSAGE = " 사이의 숫자여야 합니다.";
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "중복이 불가능 합니다.";
    private static final String NUMERIC_EXCEPTION_MESSAGE = "숫자만 입력 가능합니다.";

    public static void validateLotto(List<Integer> numbers) {
        StringBuilder message = new StringBuilder(ERROR_MESSAGE);

        if (!isAccurateSize(numbers)) {
            message.append(LottoStatus.count.getValue()).append(LENGTH_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException(message.toString());
        } else if (hasDuplication(numbers)) {
            message.append(DUPLICATE_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException(message.toString());
        } else if (!isAccurateRange(numbers)) {
            message.append(LottoStatus.startInclusive.getValue()).append("부터 ")
                    .append(LottoStatus.endInclusive.getValue()).append(RANGE_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException(message.toString());
        }
    }

    public static List<Integer> validateWinningNumbers(String input) {
        List<Integer> numbers = getNumbers(input);
        validateLotto(numbers);
        return numbers;
    }

    public static int validateNumber(String input) {
        int number = getNumber(input);

        if (!isAccurateRange(List.of(number))) {
            StringBuilder message = new StringBuilder(ERROR_MESSAGE);
            message.append(LottoStatus.startInclusive.getValue()).append("부터 ")
                    .append(LottoStatus.endInclusive.getValue()).append(RANGE_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException(message.toString());
        }

        return number;
    }

    public static void validDuplication(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            StringBuilder message = new StringBuilder(ERROR_MESSAGE);
            message.append(DUPLICATE_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException(message.toString());
        }
    }

    private static int getNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            StringBuilder message = new StringBuilder(ERROR_MESSAGE);
            throw new IllegalArgumentException(message.append(NUMERIC_EXCEPTION_MESSAGE).toString());
        }
    }

    private static List<Integer> getNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            StringBuilder message = new StringBuilder(ERROR_MESSAGE);
            throw new IllegalArgumentException(message.append(NUMERIC_EXCEPTION_MESSAGE).toString());
        }
    }

    private static boolean isAccurateSize(List<Integer> numbers) {
        if (numbers.size() != LottoStatus.count.getValue()) return false;
        return true;
    }

    private static boolean hasDuplication(List<Integer> numbers) {
        Set<Integer> stack = new HashSet<>();
        for (Integer number : numbers) {
            if (!stack.add(number)) return true;
        }
        return false;
    }

    private static boolean isAccurateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(LottoStatus.startInclusive.getValue() <= number && number <= LottoStatus.endInclusive.getValue())) {
                return false;
            }
        }
        return true;
    }
}
