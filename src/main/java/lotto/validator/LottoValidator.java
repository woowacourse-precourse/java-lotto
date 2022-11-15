package lotto.validator;

import static lotto.ErrorMessage.INVALID_LOTTO_NUMBER_SIZE_ERROR;
import static lotto.ErrorMessage.WINNING_NUMBER_NOT_NUMBER_INPUT_ERROR;
import static lotto.ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR;
import static lotto.ErrorMessage.PURCHASE_AMOUNT_NOT_DIVIDED_BY_1000_ERROR;
import static lotto.ErrorMessage.BONUS_NUMBER_EXIST_IN_WINNING_NUMBER_ERROR;
import static lotto.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE_ERROR;

import lotto.random.LottoNumberGenerator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class LottoValidator {
    public static <T> void validateLottoNumberSize(List<T> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_SIZE_ERROR);
        }
    }

    public static void validateNumber(String input, String errorMessage) {
        for (char inputLetter : input.toCharArray()) {
            if (!Character.isDigit(inputLetter)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    public static void validateNumber(List<String> splitedWinningNumber) {
        splitedWinningNumber.stream()
                .forEach(winningNumber -> validateNumber(winningNumber, WINNING_NUMBER_NOT_NUMBER_INPUT_ERROR));
    }

    public static void validateDuplicateNumber(List<Integer> lottoNumber) {
        Set<Integer> duplicateCheck = new HashSet<>(lottoNumber);
        if (lottoNumber.size() != duplicateCheck.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }

    public static void validatePurchaseAmountDividedBy1000(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_DIVIDED_BY_1000_ERROR);
        }
    }

    public static void validateNotExistInWinningNumber(int bonusNumber, List<Integer> winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_EXIST_IN_WINNING_NUMBER_ERROR);
        }
    }

    public static void validateLottoNumberRange(int lottoNumber) {
        if (isInvalidRange(lottoNumber)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    public static void validateLottoNumberRange(List<Integer> winningNumber) {
        winningNumber.stream().forEach(LottoValidator::validateLottoNumberRange);
    }

    private static boolean isInvalidRange(int number) {
        return number < LottoNumberGenerator.RANDOM_START_NUMBER
                || number > LottoNumberGenerator.RANDOM_END_NUMBER;
    }
}
