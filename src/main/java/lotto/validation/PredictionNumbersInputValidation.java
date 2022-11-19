package lotto.validation;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.validation.ErrorMessage.*;

public class PredictionNumbersInputValidation {
    public static final int QUANTITY_OF_DIGITS = 6;
    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;

    public void validateInputFormat(String inputPredictionNumbers) {
        Pattern pattern = Pattern.compile("^[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+$");

        if (! pattern.matcher(inputPredictionNumbers).matches()) {
            throw new IllegalArgumentException(INPUT_PREDICTION_NUMBERS_IN_COMMA_AND_INTEGERS.getMessage());
        }
    }

    public void validate(List<Integer> predictionNumbers) {
        validateNoDuplicateNumbers(predictionNumbers);
        validateNumbersRange(predictionNumbers);
    }

    public void validateNoDuplicateNumbers(List<Integer> predictionNumbers) {
        for (int currIdx = 0; currIdx < QUANTITY_OF_DIGITS; currIdx++) {
            int nextIdx = currIdx + 1;
            List<Integer> ElementsAfterCurrIdx = predictionNumbers.subList(nextIdx, QUANTITY_OF_DIGITS);

            if (ElementsAfterCurrIdx.contains(predictionNumbers.get(currIdx))) {
                throw new IllegalArgumentException(NO_DUPLICATE_NUMBERS.getMessage());
            }
        }
    }

    public void validateNumbersRange(List<Integer> predictionNumbers) {
        for (int number : predictionNumbers) {
            if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
                throw new IllegalArgumentException(NUMBERS_RANGE_BETWEEN_ONE_AND_FOURTYFIVE.getMessage());
            }
        }
    }
}
