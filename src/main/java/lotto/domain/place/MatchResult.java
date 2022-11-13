package lotto.domain.place;

import static lotto.domain.place.PlaceCondition.FIFTH_PLACE_CONDITION;
import static lotto.domain.place.PlaceCondition.FIRST_PLACE_CONDITION;
import static lotto.domain.place.PlaceCondition.FOURTH_PLACE_CONDITION;
import static lotto.domain.place.PlaceCondition.NONE_CONDITION;
import static lotto.domain.place.PlaceCondition.SECOND_PLACE_CONDITION;
import static lotto.domain.place.PlaceCondition.THIRD_PLACE_CONDITION;

import java.util.Arrays;

public enum MatchResult {
    //3,4,5,5+b,6   5e3, 5e4, 15e5, 3e7, 2e9
    //    int values[] = {5_000, 50_000, 150_000, 3_000_000, 2_000_000_000};
    FIRST_PLACE(FIRST_PLACE_CONDITION, 1, 2_000_000_000, "6개 일치"),
    SECOND_PLACE(SECOND_PLACE_CONDITION, 2, 3_000_000, "5개 + 보너스 볼 일치"),
    THIRD_PLACE(THIRD_PLACE_CONDITION, 3, 150_000, "5개 일치"),
    FOURTH_PLACE(FOURTH_PLACE_CONDITION, 4, 50_000, "4개 일치"),
    FIFTH_PLACE(FIFTH_PLACE_CONDITION, 5, 5_000, "3개 일치"),
    NONE(NONE_CONDITION, 6, 0, "");

    private final PlaceCondition placeCondition;
    private final int place;
    private final int matchAmount;
    private final String matchMessage;

    MatchResult(PlaceCondition placeCondition, int place, int matchAmount, String matchMessage) {
        this.placeCondition = placeCondition;
        this.place = place;
        this.matchAmount = matchAmount;
        this.matchMessage = matchMessage;
    }

    public static MatchResult findByCondition(PlaceCondition placeCondition) {
        return Arrays.stream(MatchResult.values()).filter(matchResult -> {
                    return matchResult.isEqualCondition(placeCondition);
                }).findAny()
                .orElse(NONE);
    }

    private boolean isEqualCondition(PlaceCondition placeCondition) {
        return this.placeCondition.equals(placeCondition);
    }

    @Override
    public String toString() {
        return String.format("%s (%,d)", matchMessage, matchAmount);
    }
}
