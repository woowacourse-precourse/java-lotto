package lotto;

public class BonusNumber {

    public static final String BLANK = " ";
    public static final String INPUT_NUMBER_BLANK = "[ERROR] 공백이 포함되어 있습니다.";

    private static final int DEFAULT_LENGTH = 1;
    private static final String INPUT_NOT_BONUS_NUMBER = "[ERROR] 올바른 보너스 숫자가 아닙니다.";
    private static final String INPUT_BONUS_NUMBER_DEFAULT_LENGTH = "[ERROR] 입력한 보너스 숫자 길이가 한자리가 아닙니다.";

    private final int inputBonusNumber;

    public BonusNumber(String inputBonusNumber) {
        this.inputBonusNumber = validate(inputBonusNumber);
    }

    private int validate(String inputBonusNumber) {
        validateBlank(inputBonusNumber);
        validateBonusNumberLength(inputBonusNumber);
        return validateInputBonusNumberType(inputBonusNumber);
    }

    private void validateBlank(String inputBonusNumber) {
        if (inputBonusNumber.contains(BLANK)) {
            throw new IllegalArgumentException(INPUT_NUMBER_BLANK);
        }
    }

    private void validateBonusNumberLength(String inputBonusNumber) {
        if (inputBonusNumber.length() != DEFAULT_LENGTH) {
            throw new IllegalArgumentException(INPUT_BONUS_NUMBER_DEFAULT_LENGTH);
        }
    }

    private int validateInputBonusNumberType(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (IllegalArgumentException exceptionMessage) {
            throw new IllegalArgumentException(INPUT_NOT_BONUS_NUMBER);
        }
    }

    public int getInputBonusNumber() {
        return inputBonusNumber;
    }

}
