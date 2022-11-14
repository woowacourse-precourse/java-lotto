package lotto;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private final int cntOfMatchedNum;
    private final int prize;
    private final String message;


    Rank(int cntOfMatchedNum, int prize, String message) {
        this.cntOfMatchedNum = cntOfMatchedNum;
        this.prize = prize;
        this.message = message;
    }

    public static final Rank getRank(int numberOfMatched) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.cntOfMatchedNum == numberOfMatched)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 3개 이상 일치하지 않습니다."));
    }

    public int getCntOfMatchedNum() {
        return cntOfMatchedNum;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
