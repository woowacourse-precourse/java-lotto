package lotto.domain;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.constant.ConstValue.*;
import static lotto.constant.Message.*;

public class Validator {

    private void validateRange(List<Integer> numbers) {
        int count = (int) numbers.stream()
                .filter(number -> number >= LOTTO_NUMBER_MINIMUM)
                .filter(number -> number <= LOTTO_NUMBER_MAXIMUM)
                .count();

        if (count != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_NUMBER_INPUT_FORMAT_MESSAGE);
        }
    }

    private void validateUnit(String inputPrice) {
        int price = Integer.parseInt(inputPrice);

        if (price % PURCHASED_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_MONEY_UNIT_INPUT_MESSAGE);
        }
    }

    private void validateMinimum(String inputPrice) {
        int price = Integer.parseInt(inputPrice);

        if (price < PURCHASED_AMOUNT_UNIT) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LESS_THAN_MINIMUM_MONEY_INPUT_MESSAGE);
        }
    }

    private void validateDigit(String input) {
        if (!Pattern.matches(DIGIT_REGEX, input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_MONEY_INPUT_FORMAT_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers, String inputBonus) {
        int bonus = Integer.parseInt(inputBonus);

        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATE_LOTTO_NUMBER_MESSAGE);
        }
    }


    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_LOTTO_NUMBER_SIZE_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int count = (int) numbers.stream().distinct().count();
        if (count < 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATE_LOTTO_NUMBER_MESSAGE);
        }
    }

    public void validateWinningLottoPattern(String lottoNumbers) {
        if (!Pattern.matches(WINNING_NUMBER_INPUT_PATTERN, lottoNumbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_WINNING_LOTTO_INPUT_FORMAT_MESSAGE);
        }
    }

    public void validateWinningLotto(List<Integer> lotto) {
        validateRange(lotto);
        validateDuplicate(lotto);
        validateNumbersSize(lotto);
    }

    public void validateBonusNumber(List<Integer> lotto, String bonusNumber) {
        validateDigit(bonusNumber);

    }

    public void validatePurchasedAmount(String purchasedAmount) {
        validateDigit(purchasedAmount);
        validateUnit(purchasedAmount);
        validateMinimum(purchasedAmount);
    }
}
