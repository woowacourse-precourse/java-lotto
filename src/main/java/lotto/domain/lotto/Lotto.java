package lotto.domain.lotto;

import lotto.exception.ErrorPrefix;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 제공된 Lotto 클래스를 활용해 구현해야 한다.
 * Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
 * numbers의 접근 제어자인 private을 변경할 수 없다.
 * Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
 * Lotto의 패키지 변경은 가능하다.
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            String message = ErrorPrefix.IllegalArgumentException.getPrefix()
                    + "로또는 6개의 숫자여야합니다.";
            System.out.println(message);
            throw new IllegalArgumentException(message);
        }

    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateDuplication(List<Integer> numbers) {
        int size = numbers.stream().collect(Collectors.toSet()).size();
        if (size != 6) {
            String message = ErrorPrefix.IllegalArgumentException.getPrefix()
                    + "로또숫자는 중복되지 않아야합니다.";
            System.out.println(message);
            throw new IllegalArgumentException(message);
        }

    }
}
