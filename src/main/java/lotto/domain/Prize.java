package lotto.domain;

import java.util.Arrays;

public enum Prize {

    THREE(3,5000L),
    FOUR(4,50000L),
    FIVE(5,1_500_000L),
    FIVE_AND_BONUS(6,30_000_000L),
    SIX(6,2_000_000_000L),
    NOTING(0, 0L),;

    private final Integer prizeNumber;
    private final Long prizeMoney;
    Prize(Integer prize,Long prizeMoney) {
        this.prizeNumber = prize;
        this.prizeMoney = prizeMoney;
    }

    public Long getPrizeMoney() {
        return prizeMoney;
    }

    public Integer getPrizeNumber() {
        return prizeNumber;
    }

    public static Prize of(Integer prize) {
        if (prize == 6) {
            return Prize.SIX;
        }
        return Arrays.stream(Prize.values())
                .filter(find -> find.getPrizeNumber().equals(prize))
                .findFirst()
                .orElse(Prize.NOTING);
    }

}