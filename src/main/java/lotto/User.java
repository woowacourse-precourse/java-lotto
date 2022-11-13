package lotto;

import lotto.input.InputReader;
import lotto.random.LottoNumberGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.ErrorMessage.*;
import static lotto.util.WinningNumberConverter.convertToImmutableIntegerList;
import static lotto.util.WinningNumberConverter.convertToImmutableStringList;

public class User {
    private final InputReader inputReader;

    public User(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public Integer inputPurchaseAmount() {
        String purchaseAmountInput = inputReader.readLine();
        validatePurchaseAmount(purchaseAmountInput);
        return Integer.valueOf(purchaseAmountInput);
    }

    public List<Integer> inputWinningNumber() {
        String winningNumberInput = inputReader.readLine();
        validateWinningNumber(winningNumberInput);
        return convertToImmutableIntegerList(winningNumberInput);
    }

    public int inputBonusNumber() {
        String bonusNumberInput = inputReader.readLine();
        validateBonusNumber(bonusNumberInput);
        return Integer.valueOf(bonusNumberInput);
    }

    private void validateBonusNumber(String bonusNumberInput) {
        validateNumber(bonusNumberInput, BONUS_NUMBER_NOT_NUMBER_ERROR);
        validateLottoNumberRange(Integer.valueOf(bonusNumberInput));
    }

    private void validateWinningNumber(String winningNumberInput) {
        List<String> splitedWinningNumber = convertToImmutableStringList(winningNumberInput);
        if (splitedWinningNumber.size() != 6) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_SIZE_ERROR);
        }

        for (String winningNumber : splitedWinningNumber) {
            validateNumber(winningNumber, WINNING_NUMBER_NOT_NUMBER_INPUT_ERROR);
        }
        List<Integer> winningNumber = convertToImmutableIntegerList(splitedWinningNumber);
        validateLottoNumberRange(winningNumber);
        validateDuplicateNumber(winningNumber);
    }

    private void validateDuplicateNumber(List<Integer> winningNumber) {
        Set<Integer> dupCheck = new HashSet<>(winningNumber);
        if (winningNumber.size() != dupCheck.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }

    private void validateLottoNumberRange(List<Integer> winningNumber) {
        winningNumber.stream().forEach(this::validateLottoNumberRange);
    }

    private void validateLottoNumberRange(Integer lottoNumber) {
        if (isInvalidRange(lottoNumber)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    private void validatePurchaseAmount(String purchaseAmountInput) {
        validateNumber(purchaseAmountInput, PURCHASE_AMOUNT_NOT_NUMBER_INPUT_ERROR);

        Integer purchaseAmount = Integer.valueOf(purchaseAmountInput);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_DIVIDED_BY_1000_ERROR);
        }
    }

    private void validateNumber(String input, String errorMessage) {
        for (char inputLetter : input.toCharArray()) {
            if (!Character.isDigit(inputLetter)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    private boolean isInvalidRange(int number) {
        return number < LottoNumberGenerator.RANDOM_START_NUMBER
                || number > LottoNumberGenerator.RANDOM_END_NUMBER;
    }
}
