package lotto.lottery.validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.util.Constant;

public class ValidateLotto {

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE_HEAD);
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> items = new HashSet<>();
        numbers.stream()
                .filter(n -> !items.add(n))
                .collect(Collectors.toSet());
        if (items.size() != numbers.size()) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE_HEAD);
        }
    }

}
