package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(String input, List<Integer> winningNumbers) {
        bonusNumber = validate(input, winningNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private int validate(String input, List<Integer> winningNumbers) {
        int inputNumber = isNumber(input);
        isInCorrectRange(inputNumber);
        isContainsWinningNumbers(inputNumber, winningNumbers);
        return inputNumber;
    }

    private int isNumber(String input) {
        try {
            int inputNumber = Integer.valueOf(input);
            return inputNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private void isInCorrectRange(int inputNumber) {
        if (inputNumber < 1 || inputNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void isContainsWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }
}
