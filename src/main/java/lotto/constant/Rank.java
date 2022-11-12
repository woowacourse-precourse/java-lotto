package lotto.constant;

import java.util.List;

public enum Rank {

    THREE_MATCHES(5_000, "3개 일치 (%,d원) - %d개\n", 0),
    FOUR_MATCHES(50_000, "4개 일치 (%,d원) - %d개\n", 1),
    FIVE_MATCHES_WITHOUT_BONUS(1_500_000, "5개 일치 (%,d원) - %d개\n", 2),
    FIVE_MATCHES_WITH_BONUS(30_000_000, "5개 일치, 보너스 볼 일치 (%,d원) - %d개\n", 3),
    SIX_MATCHES(2_000_000_000, "6개 일치 (%,d원) - %d개\n", 4);

    private final int prizeMoney;
    private final String message;
    private final int index;

    Rank(int prizeMoney, String message, int index) {
        this.prizeMoney = prizeMoney;
        this.message = message;
        this.index = index;
    }

    public String getRank(List<Integer> matchResults) {
        return String.format(this.message, prizeMoney, matchResults.get(index));
    }

    public Integer getPrize() {
        return this.prizeMoney;
    }
}
