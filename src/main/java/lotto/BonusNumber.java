package lotto;

public class BonusNumber {
    private int bonusNumber;
    private final int START_LOTTO_NUMBER = 1;
    private final int END_LOTTO_NUMBER = 45;

    public BonusNumber(int number) {
        validate(number);
        this.bonusNumber = number;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(int number) {
        if (! isValidRange(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 1이상 45 이하의 숫자를 입력하셔야 합니다.");
        }
    }

    private boolean isValidRange(int number) {
        return START_LOTTO_NUMBER <= number && number <= END_LOTTO_NUMBER;
    }
}
