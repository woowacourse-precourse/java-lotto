package lotto.domain;

public enum Rank {
    Fifth_Place(3, 5000, false,"3개 일치 (5,000원) - "),
    Fourth_Place(4, 50000, false, "4개 일치 (50,000원) - "),
    Third_Place(5, 1500000, false,"5개 일치 (1,500,000원) - "),
    Second_Place(5, 30000000, true,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    First_Place(6, 2000000000, false,"6개 일치 (2,000,000,000원) - ");
    private final int counts;
    private final int price;
    private final boolean bonus;
    private final String explain;

    Rank(int counts, int price, boolean bonus, String explain) {
        this.counts = counts;
        this.price = price;
        this.bonus = bonus;
        this.explain = explain;
    }

    public int getCounts() {
        return counts;
    }

    public int getPrice() {
        return price;
    }

    public boolean isBonus() {
        return bonus;
    }

    public String getExplain() {
        return explain;
    }
}
