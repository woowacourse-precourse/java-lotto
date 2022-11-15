package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public enum Rank {
    NONE(0, 0, ""),
    FIRST_PLACE(6, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND_PLACE(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_PLACE(5, 1500000, "5개 일치 (1,500,000원)"),
    FOURTH_PLACE(4, 50000, "4개 일치 (50,000원)"),
    FIFTH_PLACE(3, 5000, "3개 일치 (5,000원)");

    private final int count;
    private final int reward;
    private final String introMessage;

    Rank(int count,
         int reward,
         String introMessage
    ) {
        this.count = count;
        this.reward = reward;
        this.introMessage = introMessage;
    }


    private static Rank find(Predicate<Rank> predicate) {
        return Arrays.stream(values())
                .filter(predicate)
                .findAny()
                .orElse(NONE);
    }

    public static Rank findRankWithCount(int count) {
        return find(e -> Objects.equals(e.count, count));
    }

    public static int findCountWithRank(Rank rank) {
        return rank.count;
    }

    public static int findRewardWithRank(Rank rank) {
        return rank.reward;
    }

    public static String findIntroMessageWithRank(Rank rank) {
        return rank.introMessage;
    }

    public static List<Rank> getRankOrder() {
        return List.of(FIFTH_PLACE, FOURTH_PLACE, THIRD_PLACE, SECOND_PLACE, FIRST_PLACE);
    }

    public static Map<Rank, Integer> initRankMap() {
        return new java.util.HashMap<>(Map.of(
                FIRST_PLACE, 0,
                SECOND_PLACE, 0,
                THIRD_PLACE, 0,
                FOURTH_PLACE, 0,
                FIFTH_PLACE, 0
        ));

    }
}
