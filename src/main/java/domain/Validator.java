package domain;

import vo.LottoInfo;

import java.util.HashSet;
import java.util.List;

public class Validator {

    public void validateMoneyNumber(String userMoney) {
        if (!userMoney.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자로 입력 가능합니다.");
        }
    }

    public void validateMoneyUnit(String userMoney) {
        int totalMoney = Integer.parseInt(userMoney);
        if (totalMoney % LottoInfo.PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력 가능합니다.");
        }
    }

    public void validateWinningNumberSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoInfo.LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 6개를 입력하셔야 합니다.");
        }
    }

    public void validateWinningNumberRange(List<Integer> winningNumbers) {
        for (int i = 0; i < winningNumbers.size(); i++) {
            int number = winningNumbers.get(i);
            if (!(number >= 1 && number <= 45)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public void validateWinningNumberReference(List<Integer> winningNumbers) {

        int size = new HashSet<Integer>(winningNumbers).size();

        if (size != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public void validateBonusNumberRange(String bonusNumber) {

        if (!bonusNumber.matches("(^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$)")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void validateReference(List<Integer> winningNumbers, String bonusNumber) {

        if (winningNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 겹치지 않아야 합니다.");
        }
    }

}
