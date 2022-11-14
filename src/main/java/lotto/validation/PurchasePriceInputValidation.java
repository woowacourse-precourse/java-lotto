package lotto.validation;

public class PurchasePriceInputValidation {
    public void validateConsistedOnlyOfNumbers(String inputPurchasePrice) {
        try {
            Integer.parseInt(inputPurchasePrice);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로만 입력해야 합니다.");
        }
    }

    public void validateDividedByThousand(String inputPurchasePrice) {
        int purchasePrice = Integer.parseInt(inputPurchasePrice);

        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000으로 나누어떨어져야 합니다.");
        }
    }
}
