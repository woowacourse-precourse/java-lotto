package lotto.domain;

import java.util.List;

public class Valid {
    public static final int lottoPrice = 1000;

    public void isCorrectSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void isCorrectRange(List<Integer> numbers) throws IllegalArgumentException {
        if (!numbers.stream()
                .allMatch(number -> (number > 0 && number < 46))) {
            throw new IllegalArgumentException();
        }
    }

    public void isNoDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public void isNumeric(String amount) throws IllegalArgumentException {
        if (!amount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }

    public void isCorrectPrice(String amount) throws IllegalArgumentException {
        if (Integer.parseInt(amount) % lottoPrice != 0) {
            throw new IllegalArgumentException();
        }
    }
}
