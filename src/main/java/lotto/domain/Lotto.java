package lotto.domain;

import lotto.exception.DuplicateNumberException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        /* 로또 번호 개수 검증 */
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        /* 로또 번호 중복 여부 검증 */
        Map<Integer, Integer> duplicateCheckMap = new HashMap<>();
        if(numbers.stream()
                .map(n -> duplicateCheckMap.putIfAbsent(n,1))
                .anyMatch(o -> o != null)) {

            throw new DuplicateNumberException("중복된 숫자를 입력하셨습니다");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
