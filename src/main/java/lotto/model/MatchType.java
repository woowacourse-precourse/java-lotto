package lotto.model;

public enum MatchType {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5.5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final double numberMatched;
    private final int prizeMoney;

    MatchType(double numberMatched, int prizeMoney) {
        this.numberMatched = numberMatched;
        this.prizeMoney = prizeMoney;
    }

    public double getNumberMatched() {
        return numberMatched;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static MatchType fromNumberMatched(double numberMatched) {
        if (numberMatched == MatchType.THREE.numberMatched) {
            return MatchType.THREE;
        }
        if (numberMatched == MatchType.FOUR.numberMatched) {
            return MatchType.FOUR;
        }
        if (numberMatched == MatchType.FIVE.numberMatched) {
            return MatchType.FIVE;
        }
        if (numberMatched == MatchType.FIVE_BONUS.numberMatched) {
            return MatchType.FIVE_BONUS;
        }
        if (numberMatched == MatchType.SIX.numberMatched) {
            return MatchType.SIX;
        }
        return null;
    }
}
