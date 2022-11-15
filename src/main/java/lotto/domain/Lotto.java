package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {

        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    public void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int a : numbers) {
            if (a < 1 || a > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        // TODO: 추가 기능 구현
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    public static void validateBonus(List<Integer> winningNumbers, int bonusNumber) {
        List<String> winningNumber = winningNumbers.stream().map(Object::toString)
                .collect(Collectors.toList());
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 다른 숫자여야 합니다.");
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
