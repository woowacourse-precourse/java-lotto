package lotto.domain;

import lotto.exception.ErrorCode;

/**
 * 로또를 판매하는 역할
 * 1. 구매 금액에 대한 수량 계산 책임
 * 2. 로또를 판매하는 책임
 */
public class LottoShop {

    private static final int LOTTO_PRICE = 1000;
    private Lotto lotto;

    public LottoShop(Lotto lotto) {
        this.lotto = lotto;
    }

    public void sellTo(Customer customer, int amount) {
        try {
            customer.buy(lotto.createBuyLotto(calculateQuantity(amount)));
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private int calculateQuantity(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalStateException(ErrorCode.ERROR.getMessage());
        }

        return amount / LOTTO_PRICE;
    }
}
