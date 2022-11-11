package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class LottoSystem {
    private WinningNumber winningNumber;

    public void setWinningNumbers(String numbers) throws IllegalArgumentException {
        numbers = numbers.replaceAll("\\s", "");
        validateWinningNumbers(numbers);
        List<Integer> toList = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        winningNumber = new WinningNumber(toList);
    }

    public void setBonusNumber(String number) {
        if (winningNumber == null) {
            return;
        }
        validateType(number);
        winningNumber.setBonusNumber(Integer.parseInt(number));
    }

    private void validateWinningNumbers(String input) {
        String[] numbers = input.split(",");
        validateType(numbers);
    }

    private void validateType(String[] numbers) {
        for (String number : numbers) {
            validateType(number);
        }
    }

    private void validateType(String number) {
        if (!isNumeric(number)) {
            throw new IllegalArgumentException("숫자만 입력하세요.");
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
