package lotto;

import java.util.List;

public class Winner {
//    private final integer bonusNumber;
//    private final List<Integer> winningNumbers;

    public Winner(String winningNumbers, String bonusNumber) {
    }

    private void validateFormat(String winningNumbers) {
        String[] winningNumbersSplited = winningNumbers.split(",");
        if (winningNumbersSplited.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분되는 6자리의 숫자여야 합니다.");
        }
    }

    private void validateBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 이미 당첨 번호에 포함되어 있습니다.");
        }
    }
}
