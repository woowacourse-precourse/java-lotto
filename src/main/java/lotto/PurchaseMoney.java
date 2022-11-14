package lotto;

public class PurchaseMoney {
    private final Integer purchaseMoney;

    public PurchaseMoney(Integer purchaseMoney) {
        validation(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
    }

    private void validation(Integer purchaseMoney){
        if(purchaseMoney % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구매하시는 가격은 1000의 배수여야 합니다.");
        }
    }

    public Integer getPurchaseMoney(){
        return this.purchaseMoney;
    }
}
