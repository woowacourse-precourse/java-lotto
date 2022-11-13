package lotto.model;

public class Player {
    private int purchaseAmount;
    private int LottoCount;

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public void setLottoCount(int LottoCount) {
        this.LottoCount = LottoCount;
    }

    public int getLottoCount() {
        return this.LottoCount;
    }
}
