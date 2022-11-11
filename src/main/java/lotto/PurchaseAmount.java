package lotto;

public class PurchaseAmount {
    private static final int ZERO = 0;
    private static final int THOUSAND_UNITS = 1000;
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
        } else if (!isExceedZero(amount)) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_EXCEED_ZERO.getMessage());
        } else if (!isThousandUnits(amount)) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_THOUSAND_UNITS.getMessage());
        }
    }

    private boolean isStringEmpty(String amount) {
        return amount == null || amount.isBlank();
    }

    private boolean isStringDigit(String amount) {
        return amount.chars().allMatch(Character::isDigit);
    }

    private boolean isExceedZero(String amount) {
        return convertStringToInt(amount) > ZERO;
    }

    private boolean isThousandUnits(String amount) {
        return convertStringToInt(amount) % THOUSAND_UNITS == ZERO;
    }

    private int convertStringToInt(String amount) {
        return Integer.parseInt(amount);
    }
}
