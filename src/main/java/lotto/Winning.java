package lotto;

import java.util.Arrays;

public enum Winning {
    three("3", "5,000원"),
    four("4", "50,000원"),
    five("5", "1,500,000원"),
    fiveBonus("5+", "30,000,000원"),
    six("6", "2,000,000,000원");

    private String lotto;
    private String prize;

    Winning(String lotto, String prize) {
        this.lotto = lotto;
        this.prize = prize;
    }

    public static String getReward(String lotto) {
        return Arrays.stream(Winning.values()).
                filter(winning -> winning.lotto.equals(lotto))
                .map(winning -> winning.prize)
                .findAny()
                .orElseThrow(()->new IllegalArgumentException());
    }
}
