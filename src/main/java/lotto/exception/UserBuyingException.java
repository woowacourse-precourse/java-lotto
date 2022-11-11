package lotto.exception;

public class UserBuyingException {
    private final static int LOTTO_PRICE = 1000;

    public void validBuyingException(int buyingMoney) {
        if (buyingMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구매는 1,000원 단위로 가능합니다.");
        }
    }
}
