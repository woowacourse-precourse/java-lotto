package lotto.service.validation;

import java.util.List;
import java.util.Scanner;

public class BonusNumberValidation {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    final int bonusNumber;
    List<Integer> winningNumbers;

    public BonusNumberValidation(int bonusNumber, List<Integer> winningNumbers) {
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }

    /*
    * 예외사항:
    * 1. 당첨 번호에 포함된 숫자를 뽑는 경우 (O)
    * 2. 숫자가 1-45 범위가 아닌 경우 (O)
    * 3. 2개 이상 값이 들어오는 경우 -> controller 영역에서 에러 핸들링
    * 4. 숫자 외 값이 들어올 경우 -> controller 영역에서 에러 핸들링
     */

    public boolean isValidBonusNumber() {
        BonusNumberValidation bonusNumberValidation = new BonusNumberValidation(bonusNumber, winningNumbers);
         return bonusNumberValidation.isRightRange() && bonusNumberValidation.includesWinningNumbers();
    }

    private boolean isRightRange() {
        return bonusNumber <= MAX_LOTTO_NUMBER && bonusNumber >= MIN_LOTTO_NUMBER;
    }

    private boolean includesWinningNumbers() {
        return !winningNumbers.contains(bonusNumber);
    }
}
