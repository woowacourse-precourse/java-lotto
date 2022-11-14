package lotto.domain;

import java.util.HashMap;
import java.util.Map;

import static lotto.domain.Rank.*;

public class Statistics {
    private Map<Rank, Integer> rankRecord = new HashMap<>(){{
        put(FIRST_PLACE, 0);
        put(SECOND_PLACE, 0);
        put(THIRD_PLACE, 0);
        put(FOURTH_PLACE, 0);
        put(FIFTH_PLACE, 0);
    }};
}
