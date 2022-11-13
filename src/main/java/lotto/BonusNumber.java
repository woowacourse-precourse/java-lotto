package lotto;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(WinningLotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(WinningLotto winningLotto, int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicate(winningLotto, bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (!Lotto.isInRange(bonusNumber)) {
            System.out.println("[ERROR] 1 ~ 45 사이의 숫자만 들어올 수 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(WinningLotto winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            System.out.println("[ERROR] 보너스 숫자는 당첨 숫자와 중복될 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }
}
