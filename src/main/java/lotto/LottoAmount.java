package lotto;

public class LottoAmount {

    private int amount;
    public LottoAmount(Integer purchaseAmount) {
        if(purchaseAmount%1000 != 0){
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_ERROR);
        }
        amount = purchaseAmount/1000;
    }

    public int getAmount() {
        return amount;
    }
}
