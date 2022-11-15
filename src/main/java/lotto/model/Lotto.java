package lotto.model;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.THE_NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream()
                .filter(n -> n < Constants.MINIMUM_LOTTO_NUMBER || n > Constants.MAXIMUM_LOTTO_NUMBER)
                .count() > 0) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45사이여야 합니다.");
        }
        if (numbers.size() > numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 사이에 같은 번호가 없어야 합니다.");
        }
    }
}
