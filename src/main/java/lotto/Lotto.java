package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        // 로또 번호 검증
        validation(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validation(List<Integer> numbers) {
        countValidate(numbers);
        duplicateValidation(numbers);
        integerCheckAndRangeValidate(numbers);
    }

    private void countValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 여섯자리가 아닙니다.");
            throw new IllegalArgumentException();
        }
    }

    private void duplicateValidation(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            System.out.println("[ERROR] 중복되는 수가 포함되어 있습니다");
            throw new IllegalArgumentException();
        }
    }

    private void integerCheckAndRangeValidate(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                System.out.println("[ERROR] 1 ~ 45 사이의 숫자만 입력 가능합니다");
                throw new IllegalArgumentException();
            }
        }
    }
}