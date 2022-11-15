package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        repeat(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 6개의 숫자를 입력하세요.");
            throw new IllegalArgumentException();
        }
    }

    private void repeat(List<Integer> numbers) {
        List<Integer> inputNumber = new ArrayList<>();
        for (int eachNumber : numbers) {
            if (inputNumber.contains(eachNumber)) {
                System.out.println("[ERROR] 중복된 숫자를 입력했습니다.");
                throw new IllegalArgumentException();
            } else {
                inputNumber.add(eachNumber);
            }
        }
    }
}
