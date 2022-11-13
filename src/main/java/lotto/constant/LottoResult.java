package lotto.constant;

public enum LottoResult {
    THREE_COUNT(3, 5_000,0)
    , FOUR_COUNT(4, 50_000,0)
    , FIVE_COUNT(5, 1_500_000,0)
    , FIVE_COUNT_WITH_BONUS(50, 30_000_000, 0)
    , SIX_COUNT(6, 2_000_000_000, 0);

    private int number;

    private int price;
    private int matchCount;

    LottoResult(int number, int price, int matchCount) {
        this.number = number;
        this.price = price;
        this.matchCount = matchCount;
    }

    public void addMatchCount() {
        this.matchCount += 1;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
