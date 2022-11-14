package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    /**
     * 로또 번호 개수 적합성 로직
     */
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호 개수가 6이 아닙니다.");
            throw new IllegalArgumentException();
        }
    }

    /**
     * 로또 번호 중복 체크 로직
     */
    private void validateDuplication(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); ++i) {
            if (numbers.indexOf(numbers.get(i)) != i) {
                System.out.println("[ERROR] 로또 번호 중 중복이 있습니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
