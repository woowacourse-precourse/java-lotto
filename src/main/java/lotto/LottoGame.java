package lotto;

public class LottoGame {
    public enum eLottoPlace {
        FIRST_PLACE,
        SECOND_PLACE,
        THIRD_PLACE,
        FOURTH_PLACE,
        FIFTH_PLACE,
        NOTHING
    }

    public static eLottoPlace matchLotto(Lotto l1, Lotto l2, int bonus) {
        int matches = 0;

        for (int num : l1.getNumbers()) {
            if (l2.getNumbers().contains(num)) {
                matches += 1;
            }
        }
        return checkPlace(matches, l2.getNumbers().contains(bonus));
    }

    private static eLottoPlace checkPlace(int matches, boolean isBonusMatch) {
        if (matches == 6)
            return eLottoPlace.FIRST_PLACE;
        if (matches == 5 && isBonusMatch)
            return eLottoPlace.SECOND_PLACE;
        if (matches == 5)
            return eLottoPlace.THIRD_PLACE;
        if (matches == 4)
            return eLottoPlace.FOURTH_PLACE;
        if (matches == 3)
            return eLottoPlace.FIFTH_PLACE;
        return eLottoPlace.NOTHING;
    }
}
