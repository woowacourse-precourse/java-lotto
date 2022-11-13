package lotto.domain;

import java.util.List;

public class Lotto {
    private static final Integer PRICE = 1000;
    private static final String ERROR_LOTTO_SIZE = "로또 번호는 총 6개여야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LOTTO_SIZE);
        }
    }

    public boolean isContain(Integer number) {
        return this.numbers.contains(number);
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }

    public static Integer getPrice() {
        return PRICE;
    }
}
