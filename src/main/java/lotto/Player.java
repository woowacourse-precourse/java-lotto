package lotto;

public class Player {
    private int numberOfPurchase;
    public Player() {
        Manager manager = new Manager();
        manager.requestMoneyStatementPrint();
        int money = manager.inputMoney();
        if(money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MONEY_IS_NOT_DIVISIBLE_BY_1000);
        }
        numberOfPurchase = money / 1000;
    }

}
