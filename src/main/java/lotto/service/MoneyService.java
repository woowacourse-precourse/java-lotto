package lotto.service;

public class MoneyService {
    private static final MoneyService moneyService = new MoneyService();

    public static MoneyService getMoneyService() {
        return moneyService;
    }

    public int toInteger(String inputtedMoney) {
        return Integer.parseInt(inputtedMoney);
    }
}
