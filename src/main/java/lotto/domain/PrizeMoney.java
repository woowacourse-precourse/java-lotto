package lotto.domain;

public class PrizeMoney {

    private final double prize;

    public PrizeMoney(Money ownMoney, int earnMoney) {
        this.prize = (earnMoney / (double) ownMoney.getMoney()) * 100;
    }

    public double getPrize() {
        return this.prize;
    }

}