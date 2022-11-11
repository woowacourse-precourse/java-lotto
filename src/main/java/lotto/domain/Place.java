package lotto.domain;

public class Place {
    public static final int CORRECT_NUMBER_SIX = 6;
    public static final int CORRECT_NUMBER_FIVE = 5;
    public static final int CORRECT_NUMBER_FOUR = 4;
    public static final int CORRECT_NUMBER_THREE = 3;
    public static final int CORRECT_BONUS = 1;
    private final int hasNumberCount;
    private final int bonusCount;

    public Place(int hasNumberCount, int bonusCount) {
        this.hasNumberCount = hasNumberCount;
        this.bonusCount = bonusCount;
    }

    public PlaceStatus selectPlace() {
        if (hasNumberCount == CORRECT_NUMBER_SIX) {
            return PlaceStatus.FIRST;
        }

        if (hasNumberCount == CORRECT_NUMBER_FIVE && bonusCount == CORRECT_BONUS) {
            return PlaceStatus.SECOND;
        }

        if (hasNumberCount == CORRECT_NUMBER_FIVE) {
            return PlaceStatus.THIRD;
        }

        if (hasNumberCount == CORRECT_NUMBER_FOUR) {
            return PlaceStatus.FOURTH;
        }

        if (hasNumberCount == CORRECT_NUMBER_THREE) {
            return PlaceStatus.FIFTH;
        }

        return PlaceStatus.NOTHING;
    }
}
