package lotto;

public class PurchaseAmount extends Number {
    PurchaseAmount(Integer purchaseAmount) {
        this.validate(purchaseAmount);
        this.setNumber(purchaseAmount);
    }

    private void validate(Integer purchaseAmount) {
        this.validator.throwIfNotDividedByUnitPrice(purchaseAmount);
    }

    public int getLottoCount() {
        return this.getNumber() / Constants.LOTTO_PRICE.getNumber();
    }
}
