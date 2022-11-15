package lotto.model;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if(Set.copyOf(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복이 없어야 합니다.");
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
