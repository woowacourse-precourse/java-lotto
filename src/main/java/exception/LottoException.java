package exception;

import common.message.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoException {

    public static void lottoDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();

        for (Integer number : numbers) {
            set.add(number);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ErrorMessage.EXCEPTION_START.getValue());
        if (set.size() != 6) {
            sb.append(ErrorMessage.EXCEPTION_WINNING_DUPLICATE.getValue());
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
