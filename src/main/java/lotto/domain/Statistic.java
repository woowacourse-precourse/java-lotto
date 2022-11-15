package lotto.domain;

import static lotto.service.Validation.*;

public enum Statistic {

    THREE_MATCHED(
            "3개 일치 (5,000원) - %d개",
            5000
    ),
    FOUR_MATCHED(
            "4개 일치 (50,000원) - %d개",
            50000
    ),
    FIVE_MATCHED(
            "5개 일치 (1,500,000원) - %d개",
            1500000
    ),
    FIVE_AND_BONUS_MATCHED(
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개",
            30000000
    ),
    SIX_MATCHED(
            "6개 일치 (2,000,000,000원) - %d개",
            2000000000
    );

    private final String msg;
    private final int revenue;
    private final static Statistic[] STATISTIC_INDEXED = new Statistic[] {
            null, null, null,
            THREE_MATCHED,
            FOUR_MATCHED,
            FIVE_MATCHED,
            FIVE_AND_BONUS_MATCHED,
            SIX_MATCHED
    };


    Statistic(String msg, int revenue) {
        this.msg = msg;
        this.revenue = revenue;
    }


    public static int getRevenue(int i) {
        if(isInRange(3, i, 7)) {
            return STATISTIC_INDEXED[i].revenue;
        }
        throw new IllegalArgumentException("[ERROR] 잘못된 인덱싱입니다.");
    }

    public static String getMsg(int i) {
        if(isInRange(3, i, 7)) {
            return STATISTIC_INDEXED[i].msg;
        }
        throw new IllegalArgumentException("[ERROR] 잘못된 인덱싱입니다.");
    }
}