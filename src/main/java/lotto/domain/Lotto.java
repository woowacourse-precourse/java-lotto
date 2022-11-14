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
            throw new IllegalArgumentException("[ERROR] 사이즈가 6이 아닙니다.");
        }

        Integer max = numbers.stream().max(Integer::compareTo).orElseThrow();
        Integer min = numbers.stream().min(Integer::compareTo).orElseThrow();
        if (min < 1 || max > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 숫자가 중복됩니다.");
        }
    }

    // TODO: 추가 기능 구현
    public boolean containsNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public void printNumbers() {
        System.out.println(numbers);
    }

    public int countMatchingNumber(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto.numbers::contains)
                .count();
    }
}
