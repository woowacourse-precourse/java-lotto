package lotto.constant;

public enum LottoResult {
    THREE_COUNT(3, 0)
    , FOUR_COUNT(4, 0)
    , FIVE_COUNT(5, 0)
    , FIVE_COUNT_WITH_BONUS(50, 0)
    , SIX_COUNT(6, 0);

    private int number;
    private int matchCount;

    LottoResult(int number, int matchCount) {
        this.number = number;
        this.matchCount = matchCount;
    }

    public void addMatchCount() {
        this.matchCount += 1;
    }

    public int getNumber() {
        return number;
    }
}
