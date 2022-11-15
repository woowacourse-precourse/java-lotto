package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validation.validateNumbers(numbers);
        this.numbers = numbers;
    }
    public void compareLotto(List<Integer> lotteries, int bonus) {
        long count = 0;
        boolean isBonus = numbers.contains(bonus);
        for (int number : lotteries) {
            if (numbers.contains(number)) {
                count++;
            }
        }
        Calculator.calculateLottos(count, isBonus);
    }

    public void isBonusDuplicate(int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DUPLICATE.printError());
        }
    }
}
