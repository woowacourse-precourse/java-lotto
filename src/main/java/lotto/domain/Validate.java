package lotto.domain;

import java.util.List;

import static lotto.domain.Lotto.LOTTO_NUMS_SIZE;
import static lotto.domain.Lotto.MAX_LOTTO_NUM;
import static lotto.domain.Lotto.MIN_LOTTO_NUM;

public class Validate {
    public static boolean isInRange(int number) {
        return MAX_LOTTO_NUM <= number && number <= MIN_LOTTO_NUM;
    }

    public static boolean isInRangeAll(List<Integer> nums) {
        return nums.stream()
                .filter(Validate::isInRange)
                .count() == LOTTO_NUMS_SIZE;
    }

    public static boolean isNotContains(List<Integer> nums, int num) {
        return !nums.contains(num);
    }

    public static boolean isNotDuplicate(List<Integer> nums) {
        return nums.stream()
                .distinct()
                .count() == LOTTO_NUMS_SIZE;
    }
}
