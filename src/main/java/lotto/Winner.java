package lotto;

import java.util.List;

public class Winner {
//    private final int bonusNumber;
//    private final List<Integer> winningNumbers;

    public Winner(String winningNumbers, int bonusNumber) {
        validateFormat(winningNumbers);
    }

    private void validateFormat(String winningNumbers) {
        String[] winningNumbersSplited = winningNumbers.split(",");
        if (winningNumbersSplited.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분되는 6자리의 숫자여야 합니다.");
        }
    }
}
