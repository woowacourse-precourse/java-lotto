package lotto.domain;

public class LottoPurchaser {
    private final int purchaseAmount;

    public LottoPurchaser() {
        purchaseAmount = purchase();
    }

    private int purchase(){
        return 0;
    }

    private void validate(int purchaseAmount){

    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
