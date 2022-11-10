package lotto;

public class InsertMoney {

    private static final int PRICE_PER_LOTTO = 1000;

    private int money;

    public InsertMoney(int insertMoney) {
        validateAvailableOfPurchase(insertMoney);
        this.money = insertMoney;
    }

    static void validateAvailableOfPurchase(int insertMoney) {
        if (insertMoney % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(Error.ERROR_INSERT_MONEY_AVAILABLE.getValue());
        }
    }
}
