package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int NUMBER_SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private static final String INVALID_LOTTO_ERROR_MESSAGE
            = "[ERROR] 로또 번호는 1부터 45사이의 중복되지 않은 숫자 6개여야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (!isInCorrectRange(numbers)
                || !hasCorrectSize(numbers)
                || !noDuplicate(numbers)) {
            throw new IllegalArgumentException(INVALID_LOTTO_ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        String lottoNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList())
                .toString();
        return "로또" + lottoNumbers;
    }

    private static boolean isInCorrectRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER);
    }

    private static boolean hasCorrectSize(List<Integer> numbers) {
        return numbers.size() == NUMBER_SIZE;
    }

    private static boolean noDuplicate(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        return distinctNumbers.size() == numbers.size();
    }
}
