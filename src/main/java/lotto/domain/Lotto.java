package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("여섯개의 숫자를 입력해야 합니다");
        }
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다");
        }
        int filteredCnt = (int) numbers.stream().filter(number -> 1 <= number)
                .filter(number -> number < 45)
                .count();
        if (filteredCnt != 6) {
            throw new IllegalArgumentException("1부터 45까지의 숫자를 입력해야 합니다");
        }
    }

    @Override
    public String toString() {
        return String.join(", ", numbers.toString());
    }
}
