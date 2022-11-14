package lotto.validation;

public class PurchasePriceInputValidation {
    public static final int PRICE_OF_LOTTO = 1000;

    public void validate(String inputPurchasePrice) {
        validateConsistedOnlyOfNumbers(inputPurchasePrice);
        validateDividedByThousand(inputPurchasePrice);
    }

    public void validateConsistedOnlyOfNumbers(String inputPurchasePrice) {
        try {
            Integer.parseInt(inputPurchasePrice);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로만 입력해야 합니다.");
        }
    }

    public void validateDividedByThousand(String inputPurchasePrice) {
        int purchasePrice = Integer.parseInt(inputPurchasePrice);

        if (purchasePrice % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은" + PRICE_OF_LOTTO + "으로 나누어떨어져야 합니다.");
        }
    }
}
