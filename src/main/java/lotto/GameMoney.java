package lotto;

public class GameMoney {
    private static final int PRICE_PER_LOTTO = 1000;

    private int money;

    public GameMoney(int insertMoney) {
        validateAvailableOfPurchase(insertMoney);
        this.money = insertMoney;
    }

    static void validateAvailableOfPurchase(int insertMoney) {
        if (insertMoney % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(Error.ERROR_GAME_MONEY_AVAILABLE.getValue());
        }
    }
}
