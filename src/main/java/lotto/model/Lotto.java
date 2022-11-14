package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int NUMBER_LOWER_BOUNDS = 1;
    public static final int NUMBER_UPPER_BOUNDS = 45;
    public static final int NUMBERS_SIZE = 6;
    private static final String NUMBERS_DELIMITER = ", ";
    private static final String LOTTO_HEAD = "[";
    private static final String LOTTO_TAIL = "]";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }

        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);

        if (nonDuplicateNumbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private CompareResult compareWith(WinningNumbers winningNumbers) {
        CompareResult result = CompareResult.getDefault();

        for (Integer number : numbers) {
            result = winningNumbers.judgeWinningNumberOrBonus(number, result);
        }

        return result;
    }

    public LottoPrize getPrize(WinningNumbers winningNumbers) {
        CompareResult compareResult = compareWith(winningNumbers);

        return LottoPrize.toPrize(compareResult);
    }

    public int getWinningAmount(WinningNumbers winningNumbers) {
        return getPrize(winningNumbers).getWinningAmount();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(LOTTO_HEAD + numbers.get(0));

        for (int index = 1; index < numbers.size(); index++) {
            result.append(NUMBERS_DELIMITER).append(numbers.get(index));
        }
        result.append(LOTTO_TAIL);

        return result.toString();
    }
}
