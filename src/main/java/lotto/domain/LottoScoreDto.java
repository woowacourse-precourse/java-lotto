package lotto.domain;

public final class LottoScoreDto {
    private final int three;
    private final int four;
    private final int five;
    private final int fiveBonus;
    private final int six;
    private final double rate;

    public LottoScoreDto(int three, int four, int five, int fiveBonus, int six, double rate) {
        this.three = three;
        this.four = four;
        this.five = five;
        this.fiveBonus = fiveBonus;
        this.six = six;
        this.rate = rate;
    }

    public int getThree() {
        return three;
    }

    public int getFour() {
        return four;
    }

    public int getFive() {
        return five;
    }

    public int getFiveBonus() {
        return fiveBonus;
    }

    public int getSix() {
        return six;
    }

    public double getRate() {
        return rate;
    }
}
