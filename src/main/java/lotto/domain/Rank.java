package lotto.domain;

public enum Rank {
    WIN5(3, "5,000", 0),
    WIN4(4, "50,000", 0),
    WIN3(5, "1,500,000", 0),
    WIN2(5, "30,000,000", 0),
    WIN1(6, "2,000,000,000", 0);


    private final int count;
    private final String price;
    private int matchCount;

    Rank(int count, String price, int matchCount) {
        this.count = count;
        this.price = price;
        this.matchCount = matchCount;
    }

    public int getCount() {
        return count;
    }

    public String getPrice() {
        return price;
    }

    public void addMatchCount() {
        matchCount++;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
