package lotto;

public enum Rank {
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    int correctCount;
    int money;
    boolean bonus;

    Rank (int correctCount, int money, boolean bonus) {
        this.correctCount = correctCount;
        this.money = money;
        this.bonus = bonus;
    }
    public static Rank findByCorrectCountAndBonus(int correctCount, boolean bonus) {
        if (correctCount == 5) {
            if (bonus) {
                return SECOND;
            }
            return THIRD;
        }

        for (Rank value : values()) {
            if (value.correctCount == correctCount) {
                return value;
            }
        }
        return null;
    }
}
