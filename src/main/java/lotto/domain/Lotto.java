package lotto.domain;

import static lotto.utils.Validation.hasDuplicatedNumber;
import static lotto.utils.Validation.isNumbersInCorrectRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또에는 총 6개의 번호가 존재해야 합니다.");
        }
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복되는 번호가 존재합니다.");
        }
        if (!isNumbersInCorrectRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        List<Integer> sortedNumbers = getSortedNumbers();

        for (int number : sortedNumbers) {
            sb.append(number).append(',').append(' ');
        }
        sb.delete(sb.length() - 2, sb.length()).append(']');

        return sb.toString();
    }
}
