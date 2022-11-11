package lotto;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(String amount) {
        validate(amount);
        this.amount = convertStringToInt(amount);
    }

    public int getAmount() {
        return amount;
    }

    private void validate(String amount) {
        if (isStringEmpty(amount) || !isStringDigit(amount)) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER.getMessage());
        }
    }

    private boolean isStringEmpty(String amount) {
        return amount == null || amount.isBlank();
    }

    private boolean isStringDigit(String amount) {
        return amount.chars().allMatch(Character::isDigit);
    }

    private int convertStringToInt(String amount) {
        return Integer.parseInt(amount);
    }
}
