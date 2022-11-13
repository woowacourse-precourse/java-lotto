package lotto.domain.seller;

public class Country implements Seller{
    private static final int LOTTO_AMOUNT = 1000;

    @Override
    public int findLottoCountByMoney(int money) {
        validateMoney(money);
        return money / LOTTO_AMOUNT;
    }

    private void validateMoney(int money) {
        if (money % LOTTO_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 " + LOTTO_AMOUNT + "로 나누어 떨어지지 않습니다.");
        }
    }
}
