package lotto.domain;

import java.util.List;

public class Valid {
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
}
