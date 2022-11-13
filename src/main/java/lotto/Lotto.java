package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        lengthCheck(numbers);
        duplicationCheck(numbers);
        ascendingOrderCheck(numbers);
        this.numbers = numbers;
    }

    private void lengthCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("숫자 길이가 6이 아닙니다.");
        }
    }

    private void duplicationCheck(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (Collections.frequency(numbers, num) != 1) {
                throw new IllegalArgumentException("숫자가 중복되었습니다.");
            }
        }
    }

    private void ascendingOrderCheck(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)) {
                throw new IllegalArgumentException("오름차순 정렬이 아닙니다.");
            }
        }
    }
}
