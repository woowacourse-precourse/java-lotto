package lotto.domain.seller;

public class Country implements Seller{
    private static final int LOTTO_AMOUNT = 1000;

    @Override
    public int findLottoCountByMoney(int money) {
        return money / LOTTO_AMOUNT;
    }
}
