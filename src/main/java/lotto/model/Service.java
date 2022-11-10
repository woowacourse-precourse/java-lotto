package lotto.model;

public class Service {

    Player player = new Player();

    public static int countLottoAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) / 1000;
    }

    public static long getProfitRates(int purchaseAmount, int winningAmount) {
        return winningAmount / purchaseAmount;
    }

}
