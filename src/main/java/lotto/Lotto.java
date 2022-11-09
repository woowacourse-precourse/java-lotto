package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        try {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR]");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    // TODO: 추가 기능 구현
}
