package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력하세요");
        } else if (hasDuplication(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다");
        } else if (outOfNumberRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 1~45 범위 안의 수만 입력하세요");
        }
    }

    void printNumbers() {
        System.out.println(numbers);
    }

    // TODO: 추가 기능 구현
}
