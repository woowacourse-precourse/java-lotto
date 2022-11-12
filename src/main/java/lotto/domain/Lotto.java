package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 제공된 Lotto 클래스를 활용해 구현해야 한다. O
 * Lotto에 매개 변수가 없는 생성자를 추가할 수 없다. O
 * numbers의 접근 제어자인 private을 변경할 수 없다. O
 * Lotto에 필드(인스턴스 변수)를 추가할 수 없다. O
 * Lotto의 패키지 변경은 가능하다. O
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateRangeNumbers(numbers);
        validateOverlapNumbers(numbers);

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리 수가 입력 되어야 합니다.");
        }
    }

    private void validateRangeNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateOverlapNumbers(List<Integer> numbers) {
        Set<Integer> pickedUniqueNumbersInRange = new HashSet<>(numbers);

        if (pickedUniqueNumbersInRange.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 수는 로또 번호로 사용할 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}