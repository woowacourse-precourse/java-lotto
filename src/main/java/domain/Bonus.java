package domain;

public class Bonus {
    private final int bonusNumber;

    public Bonus(int bonusNumber) {
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45 ) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
