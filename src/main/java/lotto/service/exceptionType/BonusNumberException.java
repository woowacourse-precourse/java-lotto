package lotto.service.exceptionType;

public class BonusNumberException {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String SCOPE_IS_NOT_CORRECT_MESSAGE = " 보너스 번호는 1~45 사이의 숫자만 입력이 가능합니다.";
    private static final String NOT_NUMERIC_BONUS_NUMBER_MESSAGE = " 보너스 번호는 숫자만 입력 가능합니다.";
    public void checkIfBonusNumberIsNumeric(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        }catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + NOT_NUMERIC_BONUS_NUMBER_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public void checkIfTheScopeIsCorrect(String bonusNumber) {
        if (Integer.parseInt(bonusNumber) < 1 || Integer.parseInt(bonusNumber) > 45) {
            System.out.println(ERROR_MESSAGE + SCOPE_IS_NOT_CORRECT_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
