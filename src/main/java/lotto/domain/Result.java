package lotto.domain;

import static lotto.viewer.ViewFormat.*;

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

    public double calculateProfit(int count) {
        return count * prize;
    }

    public String toString() {
        if (this.equals(FIVE_BONUS)) {
            return number + CONSISTENCE_WITH_BONUS + OPEN_PARENTHESIS + String.format(MONEY_FORMAT,prize) + CURRENCY + CLOSE_PARENTHESIS;
        }
        return number + CONSISTENCE + OPEN_PARENTHESIS + String.format(MONEY_FORMAT,prize) + CURRENCY + CLOSE_PARENTHESIS;
    }
}
