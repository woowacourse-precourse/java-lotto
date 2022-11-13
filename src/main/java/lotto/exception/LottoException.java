package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoException {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String LENGTH_EXCEPTION_MESSAGE = "자리의 수만 가능합니다.";

    public static void validateLotto(List<Integer> numbers) {

    }

    private boolean isAccurateSize(List<Integer> numbers) {
        if(numbers.size() != 6) return false;
        return true;
    }

    private boolean hasDuplication(List<Integer> numbers) {
        Set<Integer> stack = new HashSet<>();
        for (Integer number : numbers) {
            if(!stack.add(number)) return true;
        }
        return false;
    }
}
