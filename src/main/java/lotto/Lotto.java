package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 6; i++) {
            if ((numbers.get(i) < 1) || (numbers.get(i) > 45)) {
                throw new IllegalArgumentException("[ERROR] 05 숫자가 범위가 올바르지 않습니다.");
            } else if (numbers.subList(i + 1, 6).contains(numbers.get(i))) {
                throw new IllegalArgumentException("[ERROR] 07 중복되는 숫자가 입력되었습니다.");
            }
        }
    }


    // Getter method
    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
