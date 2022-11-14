package lotto.domain;

import java.text.DecimalFormat;

public enum LottoPrize {
    FIRST_PRIZE(6, 0, 2_000_000_000),
    SECOND_PRIZE(5, 1, 30_000_000),
    THIRD_PRIZE(5, 0, 1_500_000),
    FOURTH_PRIZE(4, 0, 50_000),
    FIFTH_PRIZE(3, 0, 5_000),
    NO_PRIZE(0,0, 0);

    private final int lottoNumberCount;
    private final int bonusNumberCount;
    private final int prize;

    LottoPrize(int lottoNumberCount, int bonusNumberCount, int prize) {
        this.lottoNumberCount = lottoNumberCount;
        this.bonusNumberCount = bonusNumberCount;
        this.prize = prize;
    }

    public static LottoPrize getLottoPrize(int lottoNumberCount, int bonusNumberCount) {
        if (lottoNumberCount == FIRST_PRIZE.lottoNumberCount) return FIRST_PRIZE;
        else if (lottoNumberCount == SECOND_PRIZE.lottoNumberCount) {
            if (bonusNumberCount == SECOND_PRIZE.bonusNumberCount) return SECOND_PRIZE;
            return THIRD_PRIZE;
        }
        else if (lottoNumberCount == FOURTH_PRIZE.lottoNumberCount) return FOURTH_PRIZE;
        else if (lottoNumberCount == FIFTH_PRIZE.lottoNumberCount) return FIFTH_PRIZE;
        return NO_PRIZE;
    }

    public int getPrize(){
        return prize;
    }

    public String getPrizeInfo() {
        String info = "";
        DecimalFormat df = new DecimalFormat("###,###");
        if (lottoNumberCount > 0) info += String.format("%d개 일치",lottoNumberCount);
        if (bonusNumberCount > 0) info += String.format(", 보너스 볼 일치");
        if (prize > 0) info += String.format(" (%s)원", df.format(prize));
        return info;
    }
}
