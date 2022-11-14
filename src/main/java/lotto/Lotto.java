package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 번호의 개수는 6이어야 합니다.");
        }

        Set<Integer> numberConsisted = new HashSet<>();
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 숫자의 범위는 1 ~ 45 입니다.");
            }
            numberConsisted.add(number);
        }
        if (numberConsisted.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }

    public void printNumbers() {
        System.out.println(Arrays.toString(numbers.toArray()));
    }
}
