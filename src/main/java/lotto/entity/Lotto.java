package lotto.entity;

import static lotto.entity.LottoConstant.COUNT;
import static lotto.entity.LottoConstant.RANGE_END;
import static lotto.entity.LottoConstant.RANGE_START;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT.getValue()) {
            throw new IllegalArgumentException(
                "로또는 " + COUNT.getValue() + "개를 가져야 합니다. 입력 : " + numbers.size());
        }
        if (hasOutOfRangeNumber(numbers)) {
            throw new IllegalArgumentException(
                "로또 번호는 " + RANGE_START.getValue() + "부터 " + RANGE_END.getValue()
                    + " 사이의 숫자여야 합니다. 입력 : " + numbers);
        }
        if (hasDuplication(numbers)) {
            throw new IllegalArgumentException("로또 번호는 중복된 숫자를 가지면 안됩니다. 입력 : " + numbers);
        }
    }

    // TODO: 추가 기능 구현

    private boolean hasOutOfRangeNumber(List<Integer> numbers) {
        return numbers.stream()
            .anyMatch(this::outOfRange);
    }

    private boolean outOfRange(int number) {
        return RANGE_START.getValue() > number || RANGE_END.getValue() < number;
    }

    private boolean hasDuplication(List<Integer> numbers) {
        return numbers.stream()
            .distinct()
            .count() != COUNT.getValue();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
