package lotto.domain;

public class Price {
    private final Integer purchasePrice;

    public Price(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }
}
