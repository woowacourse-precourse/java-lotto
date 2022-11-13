package lotto;

import lotto.input.InputReader;

public class User {
    private final InputReader inputReader;

    public User(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public Integer askPurchaseAmount() {
        String purchaseAmountInput = inputReader.readLine();
        validatePurchaseAmount(purchaseAmountInput);
        return Integer.valueOf(purchaseAmountInput);
    }

    private void validatePurchaseAmount(String purchaseAmountInput) {
        for (char inputLetter : purchaseAmountInput.toCharArray()) {
            if (!Character.isDigit(inputLetter)) {
                throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_NUMBER_INPUT_ERROR);
            }
        }

        Integer purchaseAmount = Integer.valueOf(purchaseAmountInput);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_DIVIDED_BY_1000_ERROR);
        }
    }
}
