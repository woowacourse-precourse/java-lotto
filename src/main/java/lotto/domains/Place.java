package lotto.domains;

import java.util.Arrays;

public enum Place {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000),
    ZERO(0, false, 0);

    private final int correction;
    private final boolean bonus;
    private final int prize;

    public int getCorrection() {
        return correction;
    }

    public int getPrize() {
        return prize;
    }

    Place(int correction, boolean bonus, int prize) {
        this.correction = correction;
        this.bonus = bonus;
        this.prize = prize;
    }

    public static Place getPlace(int count, boolean bonus) {
        if (bonus && count == Place.SECOND.correction) {
            return Arrays.stream(Place.values())
                    .filter(place -> place.correction == count && place.bonus == bonus)
                    .findAny()
                    .orElse(ZERO);
        }
        return Arrays.stream(Place.values())
                .filter(place -> place.correction == count)
                .findAny()
                .orElse(ZERO);
    }

}
