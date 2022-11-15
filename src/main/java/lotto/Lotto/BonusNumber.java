package lotto.Lotto;

public class BonusNumber {
    private static final Integer BONUS_NUMBER_LENGTH = 1;
    private static final Integer MINIMUM_RANGE_OF_BONUS_NUMBER = 1;
    private static final Integer MAXIMUM_RANGE_OF_BONUS_NUMBER = 45;

    private static final String NOT_NUMERIC_WARNING_MESSAGE = "[ERROR] 보너스 볼은 숫자여야 합니다.";
    private static final String BONUS_NUMBER_OUT_OF_RANGE_WARNING_MESSAGE = "[ERROR] 보너스 볼은 1부터 45 사이의 숫자여야 합니다.";

    private Integer bonusNumber;

    public BonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);

        this.bonusNumber = Integer.valueOf(bonusNumber);
    }

    private void validateBonusNumber(String bonusNumber) {
        Integer numericBonusNumber;

        validateNumeric(bonusNumber);
        numericBonusNumber = Integer.valueOf(bonusNumber);

        validateBonusNumberRange(numericBonusNumber);

    }

    private void validateNumeric(String bonusNumber) {
        try {
            Double.parseDouble(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_WARNING_MESSAGE);
        }
    }

    private void validateBonusNumberRange(Integer bonusNumber) {
        if (bonusNumber < MINIMUM_RANGE_OF_BONUS_NUMBER || bonusNumber > MAXIMUM_RANGE_OF_BONUS_NUMBER) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE_WARNING_MESSAGE);
        }
    }

}
