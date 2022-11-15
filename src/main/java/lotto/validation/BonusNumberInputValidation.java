package lotto.validation;

import java.util.List;

import static lotto.validation.ErrorMessage.*;

public class BonusNumberInputValidation {
    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;

    public void validate(List<Integer> predictionNumbers, String inputBonusNumber) {
        validateInputIsInteger(inputBonusNumber);
        validateNoDuplicationWithPredictionNumbers(predictionNumbers, inputBonusNumber);
        validateNumberRange(inputBonusNumber);
    }

    public void validateInputIsInteger(String inputBonusNumber) {
        try {
            Integer.parseInt(inputBonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(INPUT_BONUS_NUMBER_IN_INTEGER.getMessage());
        }
    }

    public void validateNoDuplicationWithPredictionNumbers(List<Integer> predictionNumbers, String inputBonusNumber) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        if (predictionNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(NO_DUPLICATION_WITH_PREDICTION_NUMBERS.getMessage());
        }
    }

    public void validateNumberRange(String inputBonusNumber) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        if (bonusNumber < MIN_LOTTO_NUM || bonusNumber > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(NUMBERS_RANGE_BETWEEN_ONE_AND_FOURTYFIVE.getMessage());
        }
    }
}
