package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbersSort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개만 입력 할 수 있습니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되는 번호는 입력 할 수 없습니다.");
        }

        int max = Collections.max(uniqueNumbers);
        int min = Collections.min(uniqueNumbers);
        if (min < 1 || 45 < max) {
            throw new IllegalArgumentException("[ERROR] 1~45의 정수만 입력 할 수 있습니다.");
        }
    }

    private List<Integer> numbersSort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String toString() {
        return numbers.toString();
    }
    // TODO: 추가 기능 구현
}
