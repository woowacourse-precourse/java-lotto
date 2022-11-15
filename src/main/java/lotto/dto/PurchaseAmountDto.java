package lotto.dto;

public class PurchaseAmountDto {
    private int purchaseAmount;

    private PurchaseAmountDto(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmountDto of(int purchaseAmount) {
        return new PurchaseAmountDto(purchaseAmount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
