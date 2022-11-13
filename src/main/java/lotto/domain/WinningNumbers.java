package lotto.domain;

public class WinningNumbers {
    private static final String BONUS_DUPLICATE_LOTTO_ERROR = "[ERROR] 보너스 숫자는 입력한 로또 번호들과 중복되지 않아야 합니다.";
    private static final String BONUS_OUT_OF_RANGE_ERROR = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningNumbers(Lotto lotto, int bonusNumber) {
        checkDuplicateNumber(lotto, bonusNumber);
        checkRangeOfBonusNumber(bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void checkDuplicateNumber(Lotto lotto, int bonusNumber) {
        if (lotto.containNumber(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_LOTTO_ERROR);
        }
    }

    private void checkRangeOfBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(BONUS_OUT_OF_RANGE_ERROR);
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
