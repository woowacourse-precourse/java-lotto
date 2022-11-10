package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private final static String ONLY_NUMBER = "^\\d+$";
    private final Integer bonusNumber;
    private final List<Integer> winningNumbers;

    public Winner(String winningNumbers, String bonusNumber) {
        String[] winningNumbersSplited = winningNumbers.split(",");
        validateFormat(winningNumbersSplited);
        for (String number : winningNumbersSplited) {
            validateIfNumeric(number);
        }
        validateIfNumeric(bonusNumber);

        this.winningNumbers = new ArrayList<>();
        updateWinningNumbers(winningNumbersSplited);
        validateUniqueness(this.winningNumbers);
        this.bonusNumber = Integer.valueOf(bonusNumber);
        validateRange(this.bonusNumber);
        validateIfBonusNumberIncludedInWinningNumbers();
    }

    private void validateFormat(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분되어야 합니다.");
        }
    }

    private void validateIfNumeric(String input) {
        boolean isNumber = input.matches(ONLY_NUMBER);
        if (!isNumber) {
            throw new IllegalArgumentException("[ERROR] [ERROR] 숫자가 아닌 값이 포함되어 있습니다. 공백이나 문자가 들어갔는지 확인해주세요.");
        }
    }

    private void validateRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void updateWinningNumbers(String[] numbers) {
        for (String number : numbers) {
            Integer numericValue = Integer.valueOf(number);
            validateRange(numericValue);
            winningNumbers.add(numericValue);
        }
    }

    private void validateUniqueness(List<Integer> numbers) {
        List<Integer> numbersToBeValidated = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (numbersToBeValidated.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 겹치는 번호가 존재합니다.");
        }
    }

    private void validateIfBonusNumberIncludedInWinningNumbers() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 이미 당첨 번호에 포함되어 있습니다.");
        }
    }
}
