package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int COUNT = 6;
    public static final int MIN = 1;
    public static final int MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            validNumberSize(number);
            set.add(number);
        }

        if (set.size() != 6) {
            throw new IllegalArgumentException("[ERROR]: 정확한 숫자를 입력하세요.");
        }
    }

    void validNumberSize(int number) {
        if (number < 1 && number > 45) {
            throw new IllegalArgumentException("[ERROR]: 1 ~ 45 사이의 숫자를 입력하세요");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
