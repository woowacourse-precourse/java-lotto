package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int LOTTERY_NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (numbers.get(i).equals(numbers.get(j))) {  // 중복 검사
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public String toString() {
        return numbers.toString();
    }

}
