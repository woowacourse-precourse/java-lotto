package lotto;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;
    private int shopMoney;

    public LottoShop(int shopMoney) {
        validateMoney(shopMoney);
        this.shopMoney = shopMoney;
    }

    private void validateMoney(int shopMoney) {
        if(shopMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int LottoCountCalculate() {
        int LottoCount = shopMoney / LOTTO_PRICE;
        System.out.println(LottoCount + "개를 구매했습니다.");
        return LottoCount;
    }

    public int getShopMoney() {
        return shopMoney;
    }
    
}
