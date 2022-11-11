package lotto.model.domain;

public class PayingMoney {

    private final int money;

    public PayingMoney(String requestMoney) {
        money = Integer.parseInt(requestMoney);
    }
}
