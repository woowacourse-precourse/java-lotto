package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;
    public static final int START_LOTTO_NUMBER = 1;
    public static final int END_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isInvalidNumberSize(numbers)) {
            String errorMessage = String.format("%d개의 숫자를 입력하셨습니다. 로또는 %d개의 숫자를 가져야 합니다.", numbers.size(),
                    LOTTO_NUMBER_COUNT);
            throw new IllegalArgumentException(errorMessage);
        }
        if (isInvalidNumberRange(numbers)) {
            String errorMessage = String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", START_LOTTO_NUMBER, END_LOTTO_NUMBER);
            throw new IllegalArgumentException(errorMessage);
        }
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("로또 번호는 서로 달라야 합니다.");
        }
    }

    private static boolean isInvalidNumberSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBER_COUNT;
    }

    private static boolean isInvalidNumberRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> START_LOTTO_NUMBER > number || number > END_LOTTO_NUMBER);
    }

    private static boolean hasDuplicateNumber(List<Integer> numbers) {
        long uniqueNumberCount = numbers.stream()
                .distinct()
                .count();
        return uniqueNumberCount != numbers.size();
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
