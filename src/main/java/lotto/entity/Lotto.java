package lotto.entity;

import static lotto.LottoApplication.COUNT;
import static lotto.LottoApplication.RANGE_END;
import static lotto.LottoApplication.RANGE_START;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        ArrayList<Integer> validNumbers = new ArrayList<>(numbers);
        Collections.sort(validNumbers);
        this.numbers = validNumbers;
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    // TODO: 추가 기능 구현

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(
                    String.format("로또는 %d개를 가져야 합니다. 입력 : %s", COUNT, numbers));
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (hasOutOfRangeNumber(numbers)) {
            throw new IllegalArgumentException(
                    String.format("로또 번호는 %d부터 %d사이 숫자여야 합니다. 입력 : %s", RANGE_START, RANGE_END,
                            numbers));
        }
    }

    private boolean hasOutOfRangeNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::outOfRange);
    }

    private boolean outOfRange(int number) {
        return RANGE_START > number || RANGE_END < number;
    }

    private void validateDuplication(List<Integer> numbers) {
        if (hasDuplication(numbers)) {
            throw new IllegalArgumentException(
                    String.format("로또 번호는 중복된 숫자를 가지면 안 됩니다. 입력 : %s", numbers));
        }
    }

    private boolean hasDuplication(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> cloneNumbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
