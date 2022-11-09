package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int price = 1000;
    private static final ExceptionHandler exceptionHandler = new ExceptionHandler();

    public static int numberOfLottosQuantity(int amountPaid) {
        int lottoQuantity = amountPaid/price;
        if (amountPaid%price != 0) {
            exceptionHandler.foolExceaption("amount");
        }
        return lottoQuantity;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
