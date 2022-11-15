package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THRID(5, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    FIFTH(5, 5000, "3개 일치 (5,000원) - ");

    private final int matchNumber;
    private final int reward;
    private final String message;
    private int count = 0;

    Rank(int mathNumber, int reward, String message) {
        this.matchNumber = mathNumber;
        this.reward = reward;
        this.message = message;
    }

    public int getMatchNumber() {
        return this.matchNumber;
    }

    public static Rank getRank(int matchNum) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchNumber == matchNum)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("당첨되지 않았습니다."));
    }

    public void initCount() {
        this.count = 0;
    }

    public void plus() {
        this.count++;
    }

    public String getMessage() {
        return this.message;
    }

    public String getStrCount() {
        return this.count + "개";
    }
}
