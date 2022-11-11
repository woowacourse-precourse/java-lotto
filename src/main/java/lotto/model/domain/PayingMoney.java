package lotto.model.domain;

public class PayingMoney {

    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public PayingMoney(String requestMoney) {
        money = Integer.parseInt(requestMoney);
    }

    public LottoCollection createLottoCollection() {
        int numOfLotto = money / LOTTO_PRICE;
        return new LottoCollection(numOfLotto);
    }

}
