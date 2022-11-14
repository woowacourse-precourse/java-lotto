package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class RankCreator {

    private static final Map<Double, Rank> NUM_OF_MATCH_AND_RANK = new HashMap<>();

    private static final double FIFTH_SCORE = 3;
    private static final double FOURTH_SCORE = 4;
    private static final double THIRD_SCORE = 5;
    private static final double SECOND_SCORE = 5.5;
    private static final double FIRST_SCORE = 6;

    static {
        NUM_OF_MATCH_AND_RANK.put(FIFTH_SCORE, Rank.FIFTH);
        NUM_OF_MATCH_AND_RANK.put(FOURTH_SCORE, Rank.FOURTH);
        NUM_OF_MATCH_AND_RANK.put(THIRD_SCORE, Rank.THIRD);
        NUM_OF_MATCH_AND_RANK.put(SECOND_SCORE, Rank.SECOND);
        NUM_OF_MATCH_AND_RANK.put(FIRST_SCORE, Rank.FIRST);
    }

    static Rank create(double numOfMatch) {
        return NUM_OF_MATCH_AND_RANK.getOrDefault(numOfMatch, Rank.NOTHING);
    }
}
