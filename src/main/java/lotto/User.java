package lotto;

import lotto.input.InputReader;

import java.util.List;

import static lotto.ErrorMessage.*;
import static lotto.util.WinningNumberConverter.convertToImmutableIntegerList;
import static lotto.util.WinningNumberConverter.convertToImmutableStringList;
import static lotto.validator.LottoValidator.*;

public class User {
    private final InputReader inputReader;

    public User(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public int inputPurchaseAmount() {
        String purchaseAmountInput = inputReader.readLine();
        validatePurchaseAmount(purchaseAmountInput);
        return Integer.valueOf(purchaseAmountInput);
    }

    public List<Integer> inputWinningNumber() {
        String winningNumberInput = inputReader.readLine();
        validateWinningNumber(winningNumberInput);
        return convertToImmutableIntegerList(winningNumberInput);
    }

    public int inputBonusNumber(List<Integer> winningNumber) {
        String bonusNumberInput = inputReader.readLine();
        validateBonusNumber(bonusNumberInput, winningNumber);
        return Integer.valueOf(bonusNumberInput);
    }

    private void validateBonusNumber(String bonusNumberInput, List<Integer> winningNumber) {
        validateNumber(bonusNumberInput, BONUS_NUMBER_NOT_NUMBER_INPUT_ERROR);
        Integer bonusNumber = Integer.valueOf(bonusNumberInput);
        validateLottoNumberRange(bonusNumber);
        validateNotExistInWinningNumber(bonusNumber, winningNumber);
    }

    private void validateWinningNumber(String winningNumberInput) {
        List<String> splitedWinningNumber = convertToImmutableStringList(winningNumberInput);
        validateLottoNumberSize(splitedWinningNumber);
        validateNumber(splitedWinningNumber);

        List<Integer> winningNumber = convertToImmutableIntegerList(splitedWinningNumber);
        validateLottoNumberRange(winningNumber);
        validateDuplicateNumber(winningNumber);
    }

    private void validatePurchaseAmount(String purchaseAmountInput) {
        validateNumber(purchaseAmountInput, PURCHASE_AMOUNT_NOT_NUMBER_INPUT_ERROR);
        validatePurchaseAmountDividedBy1000(Integer.valueOf(purchaseAmountInput));
    }
}
