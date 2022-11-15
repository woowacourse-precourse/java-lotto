package lotto;

import java.util.List;

public class ValidationUtil {

    public static int validateUserInputCondition(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new LottoException(ErrorResponse.INPUT_CONTAINS_CHAR_ERROR);
            }
        }

        return Integer.parseInt(input);
    }

    public static String validateWinnerNumberContainsComma(String userInput) {
        if (!userInput.contains(",")) {
            throw new LottoException(ErrorResponse.INPUT_WITHOUT_COMMA_ERROR);
        }

        return userInput;
    }

    public static String validateWinnerNumberSize(String userInput) {
        String[] trimmedInput = userInput.split(",");

        if (trimmedInput.length != 6) {
            throw new LottoException(ErrorResponse.INPUT_WRONG_SIZE_ERROR);
        }

        return userInput;
    }

    public static void validateWinnerNumberRange(List<Integer> winnerNumber) {
        for (Integer eachNumber : winnerNumber) {
            if (eachNumber < 1 || eachNumber > 45) {
                throw new LottoException(ErrorResponse.INPUT_LOTTO_RANGE_ERROR);
            }
        }
    }

    public static int validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new LottoException(ErrorResponse.INPUT_LOTTO_RANGE_ERROR);
        }

        return bonusNumber;
    }

    public static int validateBonusNumberIfExistInWinnerNumber(Lotto winnerLotto, int bonusNumber){
        List<Integer> winnerNumber = winnerLotto.getNumbers();

        if (winnerNumber.contains(bonusNumber)) {
            throw new LottoException(ErrorResponse.INPUT_BONUS_NUMBER_EXISTS);
        }

        return bonusNumber;
    }
}
