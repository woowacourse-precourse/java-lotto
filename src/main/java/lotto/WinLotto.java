package lotto;

import java.util.List;

public class WinLotto extends Lotto {

    private final int bonusNumber;

    public WinLotto(List<Integer> winNumbers, int bonusNumber) {
        super(winNumbers);
        validateBonusNumber(winNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winNumbers, int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            System.out.println("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않은 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
