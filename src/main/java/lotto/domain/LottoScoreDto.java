package lotto.domain;

public class LottoScoreDto {
    private final long three;
    private final long four;
    private final long five;
    private final long fiveBonus;
    private final long six;
    private final double rate;

    public LottoScoreDto(long three, long four, long five, long fiveBonus, long six, double rate) {
        this.three = three;
        this.four = four;
        this.five = five;
        this.fiveBonus = fiveBonus;
        this.six = six;
        this.rate = rate;
    }

    public long getThree() {
        return three;
    }

    public long getFour() {
        return four;
    }

    public long getFive() {
        return five;
    }

    public long getFiveBonus() {
        return fiveBonus;
    }

    public long getSix() {
        return six;
    }

    public double getRate() {
        return rate;
    }
}
