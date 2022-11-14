package type;

import java.util.Arrays;

public enum Rank {
    FIRST("6개 일치 (2,000,000,000원)", 2000000000, 6),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000, 5),
    THIRD("5개 일치 (1,500,000원)", 1500000, 5),
    FOURTH("4개 일치 (50,000원)", 50000, 4),
    FIFTH("3개 일치 (5,000원)", 5000, 3),
    NOTHING("없음", 0, 0);

    private String comment;
    private int price;
    private int count;

    Rank(String comment, int price, int count) {
        this.comment = comment;
        this.price = price;
        this.count = count;
    }

    public static Rank findRankByCount(int count) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.count == count)
                .findAny()
                .orElse(Rank.NOTHING);
    }

    public String getComment() {
        return comment;
    }

    public int getPrice() {
        return price;
    }
}
