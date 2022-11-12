package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public enum Prize {

    NONE(new MatchCount(-1, -1), 0, "없음"),
    THREE_MATCH(new MatchCount(3, 0), 5000, "3개 일치 (5,000원)"),
    FOUR_MATCH(new MatchCount(4, 0), 50000, "4개 일치 (50,000원)"),
    FIVE_MATCH(new MatchCount(5, 0), 1500000, "5개 일치 (1,500,000원)"),
    FIVE_BONUS_MATCH(new MatchCount(5, 1), 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH(new MatchCount(6, 0), 2000000000, "6개 일치 (2,000,000,000원)");

    private final MatchCount matchCount;
    private final int prizeMoney;
    private final String message;

    Prize(MatchCount matchCount, int prizeMoney, String message) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public static List<Prize> getAllPrize() {
        return List.of(Prize.values());
    }

    public MatchCount getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage() {
        return message;
    }

    public static Prize findPrizeType(MatchCount matchCount) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.getMatchCount().equals(matchCount))
                .findFirst()
                .orElse(NONE);
    }

    public static int getPrizeMoney(Prize prize, int count) {
        return prize.getPrizeMoney() * count;
    }

    public static List<String> makeResultMessage(HashMap<Prize, Integer> totalMatchResult) {
        List<String> resultMessages = new ArrayList<>();

        for (Prize prize : Prize.values()) {
            if (prize == NONE) {
                continue;
            }
            int count = totalMatchResult.getOrDefault(prize, 0);
            resultMessages.add(prize.getMessage() + " - " + count + "개");
        }
        return resultMessages;
    }
}
