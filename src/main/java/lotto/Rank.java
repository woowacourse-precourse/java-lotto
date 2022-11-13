package lotto;

import java.util.Arrays;

public enum Rank {
    ONE(6, 2000000000, "6개 일치 (2,000,000,000원) - "),
    TWO(50, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THREE(5, 1500000, "5개 일치 (1,500,000원) - "),
    FOUR(4, 50000, "4개 일치 (50,000원) - "),
    FIVE(3, 5000, "3개 일치 (5,000원) - ");

    private final int matchNum;
    private final int prize;
    private final String detail;
    private int count = 0;

    Rank(int matchNum, int prize, String detail) {
        this.matchNum = matchNum;
        this.prize = prize;
        this.detail = detail;
    }

    public void plus() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }

    public String getStrCount() {
        return this.count + "개";
    }

    public int getMatchNum() {
        return this.matchNum;
    }

    public int getPrize() {
        return this.prize;
    }

    public String getDetail() {
        return this.detail;
    }

    public static Rank getRank(int matchNum) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchNum == matchNum)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("당첨되지 않았습니다."));
    }

    public void initCount() {
        this.count = 0;
    }
}
