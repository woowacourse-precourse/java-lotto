package lotto.domain;

public class WinNumbers {
    private static final String BONUS_NUMBER_DUPLICATE_ERROR = "[ERROR] 입력한 보너스 번호가 당첨 번호와 중복됩니다.";
    private final Lotto winNumbers;
    private final int bonusNumber;

    public WinNumbers(Lotto winNumbers, int bonusNumber) {
        validate(winNumbers, bonusNumber);
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void validate(Lotto numbers, int bonusNumber) {
        if(numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR);
        }
    }

    public Lotto getWinNumbers() {
        return this.winNumbers;
    }
}
