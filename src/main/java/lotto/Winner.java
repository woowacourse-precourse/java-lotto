package lotto;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final static String ONLY_NUMBER = "^\\d+$";
    private final Integer bonusNumber;
    private final List<Integer> winningNumbers;

    public Winner(String winningNumbers, String bonusNumber) {
        String[] winningNumbersSplited = winningNumbers.split(",");
        validateFormat(winningNumbersSplited);
        validateBonusNumber(bonusNumber);

        this.winningNumbers = new ArrayList<>();
        updateWinningNumbers(winningNumbersSplited);
        this.bonusNumber = Integer.valueOf(bonusNumber);
    }

    private void validateFormat(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분되는 6자리의 숫자여야 합니다.");
        }
    }

    private void validateBonusNumber(String bonusNumber) {
        if (!bonusNumber.matches(ONLY_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력할 수 있습니다.");
        }
    }

    private void updateWinningNumbers(String[] numbers) {
        for (String number : numbers) {
            Integer numericValue = Integer.valueOf(number);
            winningNumbers.add(numericValue);
        }
    }
}
