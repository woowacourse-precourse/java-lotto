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
    }

    public void setLottoBonusNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }

        if(numbers.contains(number)){
            throw new IllegalArgumentException();
        }

        numbers.add(number);
    }
}
