package lotto.domain.result;

import java.util.Map;

public enum Rank {

    THREE_MATCHES(5_000, "3개 일치 (%,d원) - %d개", 0),
    FOUR_MATCHES(50_000, "4개 일치 (%,d원) - %d개", 1),
    FIVE_MATCHES_WITHOUT_BONUS(1_500_000, "5개 일치 (%,d원) - %d개", 2),
    FIVE_MATCHES_WITH_BONUS(30_000_000, "5개 일치, 보너스 볼 일치 (%,d원) - %d개", 3),
    SIX_MATCHES(2_000_000_000, "6개 일치 (%,d원) - %d개", 4);

    private final int prizeMoney;
    private final String message;
    private final int key;

    Rank(int prizeMoney, String message, int key) {
        this.prizeMoney = prizeMoney;
        this.message = message;
        this.key = key;
    }

    public String getRank(Map<Integer, Integer> result) {
        return String.format(this.message, prizeMoney, result.get(key));
    }

    public Integer getPrize() {
        return this.prizeMoney;
    }

    public Integer getKey() {
        return this.key;
    }
}
