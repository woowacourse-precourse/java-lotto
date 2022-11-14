package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberValidate {
    public static void countSixValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개만 입력 할 수 있습니다.");
        }
    }
    public static void duplicateValidate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되는 번호는 입력 할 수 없습니다.");
        }
    }

    public static void inRangeValidate(List<Integer> numbers) {
        int max = Collections.max(numbers);
        int min = Collections.min(numbers);
        if (min < 1 || 45 < max) {
            throw new IllegalArgumentException("[ERROR] 1~45의 정수만 입력 할 수 있습니다.");
        }
    }
}
