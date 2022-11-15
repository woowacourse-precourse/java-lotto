package lotto.domain;

import java.util.HashSet;
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
            throw new IllegalArgumentException("[ERROR] 로또의 숫자 개수가 올바르지 않습니다.");
        }
        Set<Integer> numbersWithoutRepetition = new HashSet<>(numbers);
        if (numbers.size() != numbersWithoutRepetition.size()) {
            throw new IllegalArgumentException("[ERROR] 로또의 숫자 간 중복이 있습니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }



    // TODO: 추가 기능 구현
}
