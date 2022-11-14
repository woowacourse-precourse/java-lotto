package lotto.validation;

public class PurchasePriceInputValidation {
    public void validateConsistedOnlyOfNumbers(String inputPurchasePrice) {
        try {
            Integer.parseInt(inputPurchasePrice);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로만 입력해야 합니다.");
        }
    }

}
