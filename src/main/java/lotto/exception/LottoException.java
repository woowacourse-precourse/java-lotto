package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 ";
    private static final String LENGTH_EXCEPTION_MESSAGE = " 자리의 수만 가능합니다.";
    private static final String RANGE_EXCEPTION_MESSAGE = " 사이의 숫자여야 합니다.";
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "중복이 불가능 합니다.";

    public static void validateLotto(List<Integer> numbers) {
        StringBuilder message = new StringBuilder(ERROR_MESSAGE);

        if(!isAccurateSize(numbers)) {
            message.append(6).append(LENGTH_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException(message.toString());
        }else if(hasDuplication(numbers)) {
            message.append(DUPLICATE_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException(message.toString());
        }else if(!isAccurateRange(numbers)) {
            message.append(1).append("부터 ").append(45).append(RANGE_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException(message.toString());
        }
    }

    private static boolean isAccurateSize(List<Integer> numbers) {
        if(numbers.size() != 6) return false;
        return true;
    }

    private static boolean hasDuplication(List<Integer> numbers) {
        Set<Integer> stack = new HashSet<>();
        for (Integer number : numbers) {
            if(!stack.add(number)) return true;
        }
        return false;
    }

    private static boolean isAccurateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(!(1 <= number && number <= 45)) return false;
        }
        return true;
    }
}
