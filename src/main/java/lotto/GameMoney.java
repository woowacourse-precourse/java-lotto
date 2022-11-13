package lotto;

public class GameMoney {
    private static final int PRICE_PER_LOTTO = 1000;

    private long money;

    public GameMoney(long insertMoney) {
        validateAvailableOfPurchase(insertMoney);
        this.money = insertMoney;
    }

    static void validateAvailableOfPurchase(long insertMoney) {
        if (insertMoney % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(Error.ERROR_GAME_MONEY_AVAILABLE.getValue());
        }
    }

    public int numberOfPurchases() {
        return (int) money / PRICE_PER_LOTTO;
    }
}
