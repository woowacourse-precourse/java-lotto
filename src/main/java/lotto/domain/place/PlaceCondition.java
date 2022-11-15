package lotto.domain.place;

import java.util.Arrays;

public enum PlaceCondition {
    FIRST_PLACE_CONDITION(6, false),
    SECOND_PLACE_CONDITION(5, true),
    THIRD_PLACE_CONDITION(5, false),
    FOURTH_PLACE_CONDITION(4, false),
    FIFTH_PLACE_CONDITION(3, false),
    NONE_CONDITION(0, false);

    private final int count;
    private final boolean isBonusMatch;

    PlaceCondition(int count, boolean isBonusMatch) {
        this.count = count;
        this.isBonusMatch = isBonusMatch;
    }

    public static PlaceCondition findByCondition(int matchCount, boolean isBonusMatch) {
        return Arrays.stream(PlaceCondition.values())
                .filter(placeCondition -> placeCondition.isEqual(matchCount, isBonusMatch)).findAny()
                .orElse(NONE_CONDITION);
    }

    private boolean isEqual(int matchCount, boolean isBonusMatch) {
        return matchCount == this.count && (!this.isBonusMatch || isBonusMatch);
    }
}
