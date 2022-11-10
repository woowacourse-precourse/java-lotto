package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Util {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_COUNT = 6;
    public static final int STANDARD = 1000;

    public static void isValidAmount(String input) {
        String str = input.trim();
        if (!str.matches("[0-9]*") || Integer.parseInt(str) % STANDARD != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_INPUT.getValue());
        }
    }

    public static void isValidWinNumbers(String input) {
        String str = input.trim();
        String[] splits = str.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String split : splits) {
            makeNumbers(numbers, split);
        }
        isValidNumber(numbers);
        isValidCount(numbers);
        hasDistinctNumbers(numbers);
    }

    private static void makeNumbers(List<Integer> numbers, String str) {
        if (!str.matches("[0-9]*")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WIN_NUMBERS_INPUT.getValue());
        }
        numbers.add(Integer.parseInt(str));
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
