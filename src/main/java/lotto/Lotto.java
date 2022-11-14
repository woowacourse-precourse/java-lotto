package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 6개의 수로 이루어져야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 수가 존재하지 않아야 합니다.");
        }
        if (numbers.stream().anyMatch(i -> i > 45 || i < 1)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1이상 45이하여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
