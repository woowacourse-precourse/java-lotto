package lotto.domain;

import java.util.Arrays;

public enum Result {
    NONE(0,0),
    THREE(3,5000),
    FOUR(4,50000),
    FIVE(5,1500000),
    FIVE_BONUS(5,30000000),
    SIX(6,2000000000);

    private final int prize;
    private final int number;
    Result(int number, int prize) {
        this.number = number;
        this.prize = prize;
    }
    public static Result valueOf(long number) {
        return Arrays.stream(values())
                .filter(result -> result.number == number)
                .findAny()
                .orElse(NONE);
    }

}
