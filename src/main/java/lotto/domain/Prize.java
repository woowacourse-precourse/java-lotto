package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static constant.Messages.*;

public enum Prize {

    NONE(new MatchCount(0, 0), 0, NONE_MESSAGE),
    THREE_MATCH(new MatchCount(3, 0), 5000, THREE_MATCH_MESSAGE),
    FOUR_MATCH(new MatchCount(4, 0), 50000, FOUR_MATCH_MESSAGE),
    FIVE_MATCH(new MatchCount(5, 0), 1500000, FIVE_MATCH_MESSAGE),
    FIVE_BONUS_MATCH(new MatchCount(5, 1), 30000000, FIVE_BONUS_MATCH_MESSAGE),
    SIX_MATCH(new MatchCount(6, 0), 2000000000, SIX_MATCH_MESSAGE);

    private final MatchCount matchCount;
    private final int prizeMoney;
    private final String message;

    Prize(MatchCount matchCount, int prizeMoney, String message) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    private MatchCount getMatchCount() {
        return matchCount;
    }

    private int getPrizeMoney() {
        return prizeMoney;
    }

    private String getMessage() {
        return message;
    }

    public static Prize findPrizeType(MatchCount matchCount) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.getMatchCount().isSameResult(matchCount))
                .findAny()
                .orElse(NONE);
    }

    public static int calculatePrizeMoney(Prize prize, int count) {
        return prize.getPrizeMoney() * count;
    }

    public static List<String> makeResultMessage(HashMap<Prize, Integer> totalMatchResult) {
        List<String> resultMessages = new ArrayList<>();

        for (Prize prize : Prize.values()) {
            if (prize == NONE) {
                continue;
            }
            int count = totalMatchResult.getOrDefault(prize, 0);
            resultMessages.add(String.format(MAKE_RESULT_MASSAGE,prize.getMessage(),count));
        }
        return resultMessages;
    }
}
