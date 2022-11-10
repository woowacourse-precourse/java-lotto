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
        for (String number : winningNumbersSplited) {
            validateIfNumeric(number);
        }
        validateIfNumeric(bonusNumber);

        this.winningNumbers = new ArrayList<>();
        updateWinningNumbers(winningNumbersSplited);
        this.bonusNumber = Integer.valueOf(bonusNumber);
        validateIfBonusNumberIncludedInWinningNumbers();
    }

    private void validateFormat(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분되는 6자리의 숫자여야 합니다.");
        }
    }

    private void validateIfNumeric(String input) {
        boolean isNumber = input.matches(ONLY_NUMBER);
        if (!isNumber) {
            throw new IllegalArgumentException("[ERROR] 띄어쓰기 없이 숫자를 입력해주세요.");
        }
    }

    private void updateWinningNumbers(String[] numbers) {
        for (String number : numbers) {
            Integer numericValue = Integer.valueOf(number);
            winningNumbers.add(numericValue);
        }
    }

    private void validateIfBonusNumberIncludedInWinningNumbers() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 이미 당첨 번호에 포함되어 있습니다.");
        }
    }
}
