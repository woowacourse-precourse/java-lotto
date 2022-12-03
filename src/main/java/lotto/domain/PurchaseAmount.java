package lotto.domain;

public class PurchaseAmount {

    private int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("구입금액은 음수가 아닙니다.");
        }
        if (purchaseAmount % 1000!=0) {
            throw new IllegalArgumentException("구입금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public int getNumberOfLotto(){
        return purchaseAmount/1000;
    }
}
