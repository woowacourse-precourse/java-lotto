package lotto;

import java.util.HashMap;
import java.util.Map;

import static lotto.Rank.*;
import static lotto.Rank.FIRST;

public final class Constants {

    public static final int NUMBER_MIN_RANGE = 1;
    public static final int NUMBER_MAX_RANGE = 45;
    public static final int LOTTO_NUMBERS_COUNT = 6;
    public static final int LOTTO_PRICE = 1000;
    public static final int COUNT_DEFAULT_VALUE = 0;

    public static final Map<Integer, Rank> RANKS = new HashMap<>() {
        {
            put(3, FIFTH);
            put(4, FOURTH);
            put(5, THIRD);
            put(6, FIRST);
        }
    };
}
