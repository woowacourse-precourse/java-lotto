package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException("로또는 6개의 숫자만 입력 가능합니다.");
        }
        if (new HashSet<>(numbers).size() != LottoConstant.NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException("로또는 중복된 숫자로 구성될 수 없습니다.");
        }
        for (int number : numbers) {
            validateNumber(number);
        }
    }

    private void validateNumber(int number) {
        if (number > LottoConstant.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(LottoConstant.MAX_NUMBER.getValue() + "보다 큰 값은 입력될 수 없습니다.");
        }
        if (number < LottoConstant.MIN_NUMBER.getValue()) {
            throw new IllegalArgumentException(LottoConstant.MIN_NUMBER.getValue() + "보다 낮은 값은 입력될 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));
            if (i != numbers.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
