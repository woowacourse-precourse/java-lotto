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
            System.out.println("[ERROR] 6개의 숫자를 입력하세요.");
            throw new IllegalArgumentException();
        }

        for (int i=1; i<numbers.size(); i++) {
            if (numbers.get(i - 1).equals(numbers.get(i))) {
                System.out.println("[ERROR] 중복되지 않은 숫자를 입력하세요.");
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
