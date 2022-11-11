package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public final static String ERROR_DUPLICATION = "[ERROR] 로또 번호가 중복됩니다.";
    public final static String ERROR_SIZE = "[ERROR] 로또 번호가 6개가 아닙니다";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_SIZE);
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplication(List<Integer> numbers) {
        boolean duplicated = numbers.stream()
            .distinct()
            .count() != numbers.size();

        if (duplicated) {
            throw new IllegalArgumentException(ERROR_DUPLICATION);
        }
    }

    @Override
    public String toString() {
        return numbers.stream().map(Object::toString)
            .collect(Collectors.joining(", ","[", "]"));
    }
}
