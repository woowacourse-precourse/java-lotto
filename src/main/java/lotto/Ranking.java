package lotto;

import java.text.DecimalFormat;

public enum Ranking {
    FirstPlace(2000000000, 6),
    SecondPlace(30000000, 5),
    ThirdPlace(1500000, 5),
    FourthPlace(50000, 4),
    FifthPlace(5000, 3);

    protected final int PRIZE_MONEY;
    protected final int HIT_COUNT_NUMBER;

    Ranking(int prizeMoney, int hit_count_number) {
        this.PRIZE_MONEY = prizeMoney;
        this.HIT_COUNT_NUMBER = hit_count_number;
    }

    public double calcGetPrizeMoney(int hitCount) {
        return PRIZE_MONEY * hitCount;
    }

    public String printMessage(int hitLotto) {
        DecimalFormat formatter = new DecimalFormat("###,###");

        if (this == SecondPlace) {
            return HIT_COUNT_NUMBER + "개 일치, 보너스 볼 일치 (" + formatter.format(PRIZE_MONEY) + "원) - " + hitLotto + "개";
        }
        return HIT_COUNT_NUMBER + "개 일치 (" + formatter.format(PRIZE_MONEY) + "원) - " + hitLotto + "개";
    }

}
