package lotto;

public class Stats {

    private final LottoResult lottoResult;
    Money money;

    public Stats(Money money, LottoResult lottoResult) {
        this.lottoResult = lottoResult;
        this.money = money;
    }

    public double getRateOfProfit() {
        long profit = lottoResult.calculateProfits();
        long amount = money.getMoney();
        return Math.round((double) profit / amount * 10) / 10.0 * 100;
    }
}
