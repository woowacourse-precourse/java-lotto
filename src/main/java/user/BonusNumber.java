package user;

import constants.LottoConstants;
import constants.UIConstants;

import java.util.List;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(String userInput, List<Integer> winNumbers) {
        validate(userInput, winNumbers);
        this.bonusNumber = Integer.parseInt(userInput);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(String userInput, List<Integer> winNumbers) {
        validateInputFormat(userInput);

        int bonusNumber = Integer.parseInt(userInput);
        validateBonusNumberIsDuplicated(bonusNumber, userInput, winNumbers);
        validateInputRange(bonusNumber);
    }

    private static void validateInputFormat(String userInput) {
        if (!userInput.matches(LottoConstants.REGEX.pattern())) {
            throw new IllegalArgumentException(UIConstants.INVALID_BONUS_INPUT_FORMAT);
        }
    }

    private static int validateBonusNumberIsDuplicated(int bonusNumber, String userInput, List<Integer> winNumbers) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(UIConstants.DUPLICATED_BONUS_NUMBER);
        }
        return bonusNumber;
    }

    private static void validateInputRange(int bonusNumber) {
        if (bonusNumber < LottoConstants.MIN_LOTTO_VALUE ||
                bonusNumber > LottoConstants.MAX_LOTTO_VALUE) {
            throw new IllegalArgumentException(UIConstants.INVALID_RANGE_BONUS_NUMBER);
        }
    }
}
