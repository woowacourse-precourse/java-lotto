package lotto.domain;

public class BonusNumber {
    private static final String BONUS_NUMBERS_RANGE_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String BONUS_NUMBER_SIZE_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 1자리 혹은 2자리의 숫자여야 합니다.";
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private final int bonusNumber;

    public BonusNumber(String bonusNumber) {
        bonusNumberSizeExceptionCheck(bonusNumber);
        bonusNumbersRangeExceptionCheck(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void bonusNumberSizeExceptionCheck(String bonusNumber) {
        if (!(bonusNumber.length() == 1 || bonusNumber.length() == 2)) {
            throw new IllegalArgumentException(BONUS_NUMBER_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void bonusNumbersRangeExceptionCheck(String bonusNumber) {
        boolean bonusNumbersRangeCheckResult = bonusNumbersRangeCheck(bonusNumber);
        if (!bonusNumbersRangeCheckResult) {
            throw new IllegalArgumentException(BONUS_NUMBERS_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private boolean bonusNumbersRangeCheck(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        return number >= LOTTO_NUMBER_MIN && number <= LOTTO_NUMBER_MAX;
    }
}
