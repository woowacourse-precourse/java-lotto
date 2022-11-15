package lotto;

import java.util.Arrays;
import java.util.List;

public enum Winnings {
    FIRST("6", "2,000,000,000"),
    SECOND("5+", "30,000,000"),
    THIRD("5", "1,500,000"),
    FOURTH("4", "50,000"),
    FIFTH("3", "5,000");


    private final String matchNumStr;
    private final String price;

    Winnings(String matchNumStr, String price) {
        this.matchNumStr = matchNumStr;
        this.price = price;
    }

    public static String getTotalWinnings(String matchNumStr) {
        return Arrays.stream(Winnings.values())
                .filter(winnings -> winnings.matchNumStr.equals(matchNumStr))
                .map(winnings -> winnings.price)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 enum 이 없습니다."));
    }
}
