package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!checkSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 입력하셔야 합니다.");
        }
        if (!checkDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복값이 없어야 합니다.");
        }
        if (!checkRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    private boolean checkSize(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean checkDuplicate(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() == 6;
    }

    private boolean checkRange(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number >= 1)
                .filter(number -> number <= 45)
                .count() == 6;
    }
}
