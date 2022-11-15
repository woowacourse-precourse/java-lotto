package lotto.domain;

public class BonusNumber {
    private final int BONUS_NUMBER;
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;

    public BonusNumber(int number) {
        validate(number);
        this.BONUS_NUMBER = number;
    }

    public int getBonusNumber() {
        return BONUS_NUMBER;
    }

    private void validate(int number) {
        if (!isValidRange(number)) {
            throw new IllegalArgumentException("로또 숫자는 1이상 45 이하의 숫자를 입력하셔야 합니다.");
        }
    }

    private boolean isValidRange(int number) {
        return START_LOTTO_NUMBER <= number && number <= END_LOTTO_NUMBER;
    }
}
