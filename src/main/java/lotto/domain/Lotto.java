package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 번호를 입력해 주세요.");
        }
    }

    private void duplicateValidate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호는 입력하실 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
