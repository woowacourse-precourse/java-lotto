package lotto;

public class PurchaseAmount {
    private static final int ZERO = 0;
    private static final int LOTTO_PRICE = 1000;
    private final int amount;
    private final int numberOfLottoPurchased;

    public PurchaseAmount(String amount) {
        validate(amount);
        this.amount = convertStringToInt(amount);
        this.numberOfLottoPurchased = calculateNumberOfLottoPurchasesByAmount(this.amount);
    }

    public int getAmount() {
        return amount;
    }

    public int getNumberOfLottoPurchased() {
        return numberOfLottoPurchased;
    }

    private void validate(String amount) {
        if (isStringEmpty(amount) || !isStringDigit(amount)) {
            ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER.throwException();
        } else if (!isExceedZero(amount)) {
            ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_EXCEED_ZERO.throwException();
        } else if (!isThousandUnits(amount)) {
            ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_THOUSAND_UNITS.throwException();
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
        return convertStringToInt(amount) % LOTTO_PRICE == ZERO;
    }

    private int convertStringToInt(String amount) {
        return Integer.parseInt(amount);
    }

    private int calculateNumberOfLottoPurchasesByAmount(int amount) {
        return amount / LOTTO_PRICE;
    }
}
