package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        sizeValidate(numbers);

        uniqueValidate(numbers);
    }

    private void uniqueValidate(List<Integer> numbers) {
        List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되어선 안됩니다.");
        }
    }

    private void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("숫자는 6개여야 합니다.");
        }
    }

    @Override
    public String toString() {
        String joinedNumbers = String.join(", ", sortNumbers()
                .stream()
                .map(number -> number.toString())
                .collect(Collectors.toList()));
        return '[' + joinedNumbers + ']';
    }

    private List<Integer> sortNumbers() {
        List<Integer> copiedNumbers = new ArrayList<>(numbers);
        copiedNumbers.sort(Comparator.comparingInt(number -> number));
        return copiedNumbers;
    }
}
