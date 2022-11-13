package lotto;

public enum LottoGrade {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    BANG(0, 0, false);

    private final int matchCount;
    private final int price;
    private final boolean isMatchBonus;

    LottoGrade(int matchCount, int price, boolean isMatchBonus) {
        this.matchCount = matchCount;
        this.price = price;
        this.isMatchBonus = isMatchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return isMatchBonus;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(matchCount).append("개 일치");
        if (isMatchBonus) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append("(").append(price).append("원)");

        return stringBuilder.toString();
    }
}
