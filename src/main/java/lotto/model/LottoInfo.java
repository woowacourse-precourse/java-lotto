package lotto.model;

public class LottoInfo {

    private final long purchaseAmount;
    private final int buyingLottoCount;

    public LottoInfo(long purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        buyingLottoCount = (int) (purchaseAmount / 1000);
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getBuyingLottoCount() {
        return buyingLottoCount;
    }
}
