package lotto.domain.lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws Exception {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws Exception {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개이어야 합니다.");
        }
        if (numbers.stream().distinct().count() != numbers.size())
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안 됩니다.");
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
