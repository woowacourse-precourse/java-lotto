package lotto.domain.vo;

public class LottoTicketResult {
    private final int matchingCount;
    private final boolean bonus;

    public LottoTicketResult(int matchingCount, boolean bonus) {
        this.matchingCount = matchingCount;
        this.bonus = bonus;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean matchBonus() {
        return bonus;
    }
}
