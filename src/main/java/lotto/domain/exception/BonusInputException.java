package lotto.domain.exception;

import java.util.List;
import lotto.Lotto;
import lotto.constants.ExceptionMessage;

public class BonusInputException {
    private static final String REGULAR_PATTERN = "^[1-9]*$";
    private static final int LAST_BETWEEN_NUMBER = 45;
    private static final int START_BETWEEN_NUMBER = 1;


    public void bonusVerificationPreparation(Lotto lottoAnswer, int bonusInput) {
        List<Integer> lottoNumber = lottoAnswer.getNumbers();
        orderBonusVerification(lottoNumber, bonusInput);
    }

    public void orderBonusVerification(List<Integer> lottoNumber, int bonusInput) {
        validateBetween(bonusInput);
        validateCharacters(bonusInput);
        validateDuplicate(lottoNumber, bonusInput);
    }

    private void validateBetween(int bonusInput) {
        if (!(bonusInput >= START_BETWEEN_NUMBER && bonusInput <= LAST_BETWEEN_NUMBER)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBERS_BETWEEN);
        }
    }

    public void validateCharacters(int bonusInput) {
        String word = String.valueOf(bonusInput);

        if (!(word.matches(REGULAR_PATTERN))) {
            throw new IllegalArgumentException(ExceptionMessage.NON_NUMERIC_CHARACTERS);
        }
    }

    private void validateDuplicate(List<Integer> lottoNumber, int bonusInput) {
        for (int lotto : lottoNumber) {
            if (lotto == bonusInput) {
                throw new IllegalArgumentException(ExceptionMessage.WINNING_DUPLICATION_INPUT);
            }
        }
    }
}
