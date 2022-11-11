package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoSystem {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;
    private List<Integer> winningNumbers;

    public LottoSystem() {
        winningNumbers = new ArrayList<>();
    }

    public void setWinningNumbers(String numbers) throws IllegalArgumentException {
        numbers = numbers.replaceAll("\\s", "");
        validateWinningNumbers(numbers);
        winningNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateWinningNumbers(String input) {
        String[] numbers = input.split(",");
        validateCount(numbers);
        validateType(numbers);
        validateRange(numbers);
    }

    private void validateCount(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("6개의 숫자를 쉼표(,)로 구분하여 입력하세요.");
        }
    }

    private void validateType(String[] numbers) {
        for (String number : numbers) {
            if (!isNumeric(number)) {
                throw new IllegalArgumentException("숫자만 입력하세요.");
            }
        }
    }

    private void validateRange(String[] numbers) {
        for (String number : numbers) {
            int currentNumber = Integer.parseInt(number);
            if (currentNumber > MAX_RANGE || currentNumber < MIN_RANGE) {
                throw new IllegalArgumentException("1부터 45까지의 숫자만 입력하세요");
            }
        }
    }

    private boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
