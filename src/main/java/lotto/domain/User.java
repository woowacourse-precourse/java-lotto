package lotto.domain;

import lotto.exception.Input;

public class User {
    private int purchaseAmount;
    private int earnedAmouont;

    public int getEarnedAmouont() {
        return earnedAmouont;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    /**
     * 도메인 로직
     */
    public void inputPurchaseAmouont(String input) {
        validateNumeric(input);
        validateUnitOfWon(input);

        this.purchaseAmount = Integer.parseInt(input);
    }

    private void validateNumeric(String input) {
        long numericLength = input.chars().filter(Character::isDigit).count();
        if (numericLength != input.length())
            throw new IllegalArgumentException(Input.NOT_NUMERIC.getErrorMessage());
    }

    private void validateUnitOfWon(String input) {
        int money = Integer.parseInt(input);
        if (money % 1000 != 0)
            throw new IllegalArgumentException(Input.WRONG_UNIT_OF_WON.getErrorMessage());
    }
}
