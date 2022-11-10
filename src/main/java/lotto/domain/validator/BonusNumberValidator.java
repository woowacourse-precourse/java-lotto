package lotto.domain.validator;

public class BonusNumberValidator extends NumberValidator {
    public static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 1~45의 범위를 벗어날 수 없습니다.";
    
    private BonusNumberValidator() {
        throw new IllegalStateException(ValidatorExceptionMessageConstants.UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
    
    public static void validate(final int bonusNumber) {
        validateOutOfRange(bonusNumber);
    }
    
    private static void validateOutOfRange(final int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
    }
}
