package lotto;

public class GameMoney {
    private static final int PRICE_PER_LOTTO = 1000;

    private long money;

    public GameMoney(long insertMoney) throws IllegalArgumentException {
        validateAvailableOfPurchase(insertMoney);
        this.money = insertMoney;
    }

    static void validateAvailableOfPurchase(long insertMoney) throws IllegalArgumentException {
        if (insertMoney % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(Error.ERROR_GAME_MONEY_AVAILABLE.getValue());
        }
    }

    public long getMoney() {
        return this.money;
    }

    public int numberOfPurchases() {
        return (int) money / PRICE_PER_LOTTO;
    }
}
