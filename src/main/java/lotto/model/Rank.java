package lotto.model;

import static lotto.constant.RankConstants.INVALID_RANK_VALUE_MSG;
import static lotto.constant.RankConstants.TO_ENUM;

import java.util.HashSet;
import java.util.Set;

public enum Rank {
    NO_5(5_000, "3개 일치 (5,000원)"),
    NO_4(50_000, "4개 일치 (50,000원)"),
    NO_3(1_500_000, "5개 일치 (1,500,000원)"),
    NO_2(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    NO_1(2_000_000_000, "6개 일치 (2,000,000,000원)");

    private static final Set<String> validRankNames = new HashSet<>();

    static {
        for (Rank rank : Rank.values()) {
            validRankNames.add(rank.name());
        }
    }

    public static Rank from(int rankValue) {
        String rankName = toRankName(rankValue);
        isValidName(rankName);
        return Rank.valueOf(rankName);
    }

    Rank(long prize, String description) {
        this.prize = prize;
        this.description = description;
    }

    private final long prize;
    private final String description;

    public long calculateTotalPrize(int count) {
        return this.prize * count;
    }

    public String getDescription() {
        return this.description;
    }

    private static String toRankName(int rankValue) {
        return TO_ENUM + rankValue;
    }

    private static void isValidName(String rankName) {
        if (!validRankNames.contains(rankName)) {
            throw new IllegalArgumentException(INVALID_RANK_VALUE_MSG);
        }
    }


}

