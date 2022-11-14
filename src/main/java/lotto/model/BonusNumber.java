package lotto.model;

import java.util.List;

public class BonusNumber {

    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;
    private final int bonusNumber;

    public BonusNumber(String input, List<Integer> winningNumbers) {
        bonusNumber = validate(input, winningNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private int validate(String input, List<Integer> winningNumbers) {
        isBlank(input);
        int inputNumber = isNumber(input);
        isInCorrectRange(inputNumber);
        isContainsWinningNumbers(inputNumber, winningNumbers);
        return inputNumber;
    }

    private void isBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해 주세요.");
        }
    }

    private int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private void isInCorrectRange(int inputNumber) {
        if (inputNumber < MIN_NUMBER_RANGE || inputNumber > MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 보너스 번호는 %d부터 %d사이의 숫자여야 합니다.", MIN_NUMBER_RANGE, MAX_NUMBER_RANGE));
        }
    }

    private void isContainsWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }
}
