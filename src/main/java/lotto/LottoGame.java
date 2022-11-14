package lotto;

public class LottoGame {
    private static final int MONEY_UNIT = 1000;
    private final int amount;
    private final Lottos lottos;

    public LottoGame(Money money) {
        this.amount = getLottoAmount(money.getMoney());
        this.lottos = new Lottos(amount);
    }

    private int getLottoAmount(int money) {
        return money / MONEY_UNIT;
    }
}