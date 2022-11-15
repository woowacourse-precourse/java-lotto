package lotto.service.exceptionType;

import java.util.List;

public class BonusNumberException {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String SCOPE_IS_NOT_CORRECT_MESSAGE = " 보너스 번호는 1~45 사이의 숫자만 입력이 가능합니다.";
    private static final String NOT_NUMERIC_BONUS_NUMBER_MESSAGE = " 보너스 번호는 숫자만 입력 가능합니다.";
    private static final String DUPLICATE_BONUS_NUMBER_MESSAGE = " 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public void checkIfBonusNumberIsNumeric(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (IllegalArgumentException e) {
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

    public void checkForDuplicateBonusNumber(List<Integer> winningNumbers, String bonusNumber) {
        if (winningNumbers.contains(Integer.parseInt(bonusNumber))) {
            System.out.println(ERROR_MESSAGE + DUPLICATE_BONUS_NUMBER_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
