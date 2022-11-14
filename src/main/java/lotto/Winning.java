package lotto;

import java.util.Arrays;

public enum Winning {
    three("3", "5,000"),
    four("4", "50,000"),
    five("5", "1,500,000"),
    fiveBonus("5+", "30,000,000"),
    six("6", "2,000,000,000");

    public String lotto;
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
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] Winning에 없는 enum 입니다."));
    }
}
