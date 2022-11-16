package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class Result {
    private final Map<Rating, Integer> result;

    public Result() {
        result = new EnumMap<>(Rating.class);

        for (Rating rating : Rating.values()) {
            result.put(rating, 0);
        }
    }

    public void updateResult(Rating rating) {
        this.result.put(rating, this.result.get(rating) + 1);
    }

    public int getResult(Rating rating) {
        return result.get(rating);
    }
}
