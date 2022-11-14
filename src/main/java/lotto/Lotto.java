package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(distinctNumbers(numbers));
        numbers.forEach(this::validateNumbers);
        this.numbers = numbers;
    }

    public int countNumbers(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public String toString() {
        return "[" + numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(","))
                + "]";
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumbers(int number) {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException("[ERROR] 로또 번호 범위는 1~45입니다.");
    }

    private List<Integer> distinctNumbers(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
