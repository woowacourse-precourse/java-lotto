package lotto.domain;

import java.util.Arrays;

public enum Match {
    NO_MATCH(0L, 0, ""),
    THREE_MATCH(5000L, 3, "3개 일치 (5,000원) - %d개"),
    FOUR_MATCH(50000L, 4, "4개 일치 (50,000원) - %d개"),

    FIVE_MATCH(1500000L, 5, "5개 일치 (1,500,000원) - %d개"),

    FIVE_BONUS_MATCH(30000000L, 5, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),

    SIX_MATCH(2000000000L, 6, "6개 일치 (2,000,000,000원) - %d개");

    private final long reward;
    private final int matchCount;
    public final String resultMessage;

    Match(long reward, int matchCount, String resultMessage) {
        this.reward = reward;
        this.matchCount = matchCount;
        this.resultMessage = resultMessage;
    }

    public static Match findByMatchCountAndMatchBonus(int matchCount, boolean isMatchBonus) {
        Match matchResult = Arrays.stream(Match.values())
                .filter(match -> match.matchCount == matchCount)
                .findAny()
                .orElse(NO_MATCH);

        if (matchResult == Match.FIVE_MATCH && isMatchBonus) {
            return Match.FIVE_BONUS_MATCH;
        }
        return matchResult;
    }

}
