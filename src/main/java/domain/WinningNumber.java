package domain;

public class WinningNumber {
    private final int MAX = 45;
    private final int MIN = 1;
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningNumber(Lotto winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningNumbers, int bonusNumber) {
        checkNumberRange(bonusNumber);
        checkDuplication(winningNumbers, bonusNumber);
    }

    private void checkNumberRange(int bonusNumber) {
        if (bonusNumber < MIN || bonusNumber > MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 중에서 선택해 주세요.");
        }
    }

    private void checkDuplication(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력하실 수 없습니다.");
        }
    }

    public Lotto getWinningNumbers() {
        return this.winningNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
