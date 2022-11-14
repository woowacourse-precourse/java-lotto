package lotto.dto;

public class PurchaseAmountDto {
    private final Integer purchaseAmount;

    public PurchaseAmountDto(Integer purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Integer getPurchaseAmount() {
        return purchaseAmount;
    }
}
