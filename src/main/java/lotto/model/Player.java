package lotto.model;

public class Player {
    private int purchaseAmount;
    private int lottoCount;

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public void setLottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public int getLottoCount() {
        return this.lottoCount;
    }
}
