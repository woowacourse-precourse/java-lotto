package lotto;

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
            throw new IllegalArgumentException();
        }
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에는 중복 숫자가 없어야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean hasDuplicatedNumber(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

}
