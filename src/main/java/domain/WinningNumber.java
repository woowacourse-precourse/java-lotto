package domain;

import java.util.HashSet;
import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumbers;
    private final String bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, String bonusNumber) {
        validateSize(winningNumbers);
        validateNumber(winningNumbers, bonusNumber);
        validateReference(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 6개를 입력하셔야 합니다.");
        }
    }

    private void validateNumber(List<Integer> winningNumbers, String bonusNumber) {

        for (int i = 0; i < winningNumbers.size(); i++) {
            int number = winningNumbers.get(i);
            if (!(number >= 1 && number <= 45)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }

        if (!bonusNumber.matches("(^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$)")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

    }

    private void validateReference(List<Integer> winningNumbers, String bonusNumber) {

        int size = new HashSet<Integer>(winningNumbers).size();

        if (size != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }

        if (winningNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 겹치지 않아야 합니다.");
        }

    }


}
