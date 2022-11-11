package lotto.domain;

public class LottoMoney {
    private int money;

    public int inputMoney(String input) {
        money = Integer.parseInt(input);
        return money;
    }
}
