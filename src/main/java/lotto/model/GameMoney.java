package lotto.model;

import lotto.utils.Errors;
import lotto.utils.Rules;

public class GameMoney {
    private long money;

    public GameMoney(long insertMoney) throws IllegalArgumentException {
        validateAvailableOfPurchase(insertMoney);
        this.money = insertMoney;
    }

    static void validateAvailableOfPurchase(long insertMoney) throws IllegalArgumentException {
        if (insertMoney % Rules.PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(Errors.ERROR_GAME_MONEY_AVAILABLE.getValue());
        }
    }

    public long getMoney() {
        return this.money;
    }

    public int numberOfPurchases() {
        return (int) money / Rules.PRICE_PER_LOTTO;
    }
}
