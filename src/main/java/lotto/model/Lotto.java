package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicationNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void checkDuplicationNumber(List<Integer> numbers) {

        for (int index = 0; index < numbers.size() - 1; index++) {
            int operand = numbers.get(index);
            compareOtherOperand(numbers, index, operand);
        }
    }

    private void compareOtherOperand(List<Integer> numbers, int index, int operand) {

        for (int compareIndex = index + 1; compareIndex < numbers.size(); compareIndex++) {
            if (numbers.get(index) == numbers.get(compareIndex)) {
                throw new IllegalArgumentException("[ERROR] 발행되는 로또 번호는 중복되지 않아야 합니다.");
            }
        }

    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
