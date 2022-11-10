package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Util {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_COUNT = 6;

    public static void isValidInput(String str) {
        if (!str.matches("[0-9]|,")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getValue());
        }
    }

    public static void isValidNumber(List<Integer> numbers) {
        Optional<Integer> result = numbers.stream()
                .filter(number -> number < MIN_NUMBER || number > MAX_NUMBER)
                .findFirst();

        if (result.isPresent()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getValue());
        }
    }

    public static void isValidCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT.getValue());
        }
    }

    public static void hasDistinctNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.HAVE_DUPLICATED_NUMBER.getValue());
        }
    }

    public static void isValidBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getValue());
        }
    }

    public static List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_COUNT);
    }
}
