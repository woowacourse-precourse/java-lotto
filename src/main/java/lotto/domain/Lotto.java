package lotto.domain;

import java.util.List;

public class Lotto {
    private static final Integer PRICE = 1000;
    private static final String ERROR_LOTTO_SIZE = "로또 번호는 총 6개여야 합니다.";
    private static final String ERROR_LOTTO_DUPLICATION = "로또 번호는 서로 다른 숫자로 이루어져야 합니다.";
    private static final String ERROR_LOTTO_RANGE = "로또 번호는 1부터 45 사이어야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LOTTO_SIZE);
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_LOTTO_DUPLICATION);
        }
        if (!numbers.stream().allMatch(n -> (n >= 1 && n <= 45))) {
            throw new IllegalArgumentException(ERROR_LOTTO_RANGE);
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
