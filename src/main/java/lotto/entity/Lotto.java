package lotto.entity;

import static lotto.service.LottoService.COUNT;
import static lotto.service.LottoService.RANGE_END;
import static lotto.service.LottoService.RANGE_START;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(
                "로또는 " + COUNT + "개를 가져야 합니다. 입력 : " + numbers.size());
        }
        if (hasOutOfRangeNumber(numbers)) {
            throw new IllegalArgumentException(
                "로또 번호는 " + RANGE_START + "부터 " + RANGE_END + " 사이의 숫자여야 합니다.");
        }
    }

    private boolean hasOutOfRangeNumber(List<Integer> numbers) {
        return numbers.stream()
            .anyMatch(this::outOfRange);
    }

    private boolean outOfRange(int number) {
        return RANGE_START > number || RANGE_END < number;
    }

    // TODO: 추가 기능 구현

    @Override
    public String toString() {
        return numbers.toString();
    }

}
