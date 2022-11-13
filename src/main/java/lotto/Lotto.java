package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_SIX.printError());
        }
        validateLottoRange(numbers);
        validateLottoDuplicate(numbers);
    }

    private void validateLottoRange(List<Integer> numbers) {
        long count = numbers.stream().filter(s -> s > 45 || s < 1).count();
        if (count != 0) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_RANGE.printError());
        }
    }

    private void validateLottoDuplicate(List<Integer> result) {
        long count = result.stream().distinct().count();
        if (count != result.size()) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_DUPLICATE.printError());
        }
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

    public int inputBonus() {
        Message.INPUT_BONUS_NUMBER.print();
        String bonus = Console.readLine();
        int result = validateBonus(bonus);
        return result;
    }

    private int validateBonus(String bonus) {
        int result;
        try {
            result = Integer.parseInt(bonus.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_NUMBER.printError());
        }
        if (result > 45 || result < 1) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_RANGE.printError());
        }
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_DUPLICATE.printError());
        }
        return result;
    }
}
