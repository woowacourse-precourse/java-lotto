package lotto;

public class PurchaseMoney {
    static final String ERROR_MESSAGE_FOR_PURCHASE_PRICE = "구매하시는 가격은 1000의 배수여야 합니다.";
    static final String ERROR_MESSAGE_FOR_PURCHASE_PRICE_UNDER_ONE = "구매하시는 가격은 양수여야 합니다.";

    private final Integer purchaseMoney;

    public PurchaseMoney(Integer purchaseMoney) {
        validation(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
    }

    private void validation(Integer purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_PURCHASE_PRICE);
        }
        if(purchaseMoney < 1){
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_PURCHASE_PRICE_UNDER_ONE);
        }
    }

    public Integer getNumberLotteryPurchasesAvailable() {
        return this.purchaseMoney / 1000;
    }
}
