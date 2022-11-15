package lotto.domain;

public class Rate {

    private final double rate;

    public Rate(Money money, PrizeResult prizeResult) {
        this.rate = getAllMoney(prizeResult) / money.getTicket() * 0.1;
    }

    private double getAllMoney(PrizeResult prizeResult) {
        int result = 0;

        for (Prize prize : Prize.values()) {
            result += prizeResult.getPrizeCount(prize) * prize.getMoney();
        }

        return result;
    }

    public double getRate() {
        return rate;
    }
}
