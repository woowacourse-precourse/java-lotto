package lotto.domain;

import java.util.stream.Stream;
import static lotto.constant.MessageConstants.*;

public enum Statistic {
    FIFTH_PLACE(FIFTH_PLACE_MESSAGE, 3,5000, 0),
    FOURTH_PLACE(FOURTH_PLACE_MESSAGE, 4,50000, 0),
    THIRD_PLACE(THIRD_PLACE_MESSAGE, 5,1500000, 0),
    SECOND_PLACE(SECOND_PLACE_MESSAGE, 5,30000000, 0),
    FIRST_PLACE(FIRST_PLACE_MESSAGE, 6,2000000000, 0);

    private final String message;
    private final int matchingCount;
    private final long prize;
    private int count;

    Statistic(String message, int matchingCount, long prize, int count) {
        this.message = message;
        this.matchingCount = matchingCount;
        this.prize = prize;
        this.count = count;
    }

    public static void setCounts(int matchingCount, boolean bonus) {
        if(matchingCount == 5 && bonus) {
            SECOND_PLACE.addCount();
            return;
        }
        Stream.of(values())
                .filter(win -> win.matchingCount == matchingCount)
                .forEach(Statistic::addCount);
    }

    public void addCount() {
        count++;
    }

    public String getMessage() {
        return message;
    }

    public int getCount() {
        return count;
    }

    public static long getTotalPrize() {
        long totalPrize = 0;
        for(Statistic win : values()) {
            totalPrize += win.prize * win.count;
        }
        return totalPrize;
    }
}
