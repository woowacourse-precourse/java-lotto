package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoSystem {
    List<Integer> winningNumbers;

    public LottoSystem() {
        winningNumbers = new ArrayList<>();
    }

    public void setWinningNumbers(String numbers) throws IllegalArgumentException {
        validateWinningNumbers(numbers);
        winningNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateWinningNumbers(String input) {
        String[] numbers = input.split(",");
        validateCount(numbers);
        validateType(numbers);
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

    private boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
