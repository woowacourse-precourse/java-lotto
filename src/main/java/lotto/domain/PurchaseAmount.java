package lotto.domain;

import static lotto.io.Message.INPUT_UNIT;

public class PurchaseAmount {

    private final long purchaseAmount;

    public PurchaseAmount(String purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = Long.parseLong(purchaseAmount);
    }

    private void validate(String amount) {
        long price = Long.parseLong(amount);

        if (price == 0 || price / Lotto.PRICE != 0) {
            throw new IllegalArgumentException(INPUT_UNIT);
        }
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }

    public long getLottoAmount() {
        return purchaseAmount / Lotto.PRICE;
    }

}
