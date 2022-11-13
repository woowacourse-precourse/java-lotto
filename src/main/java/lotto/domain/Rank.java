package lotto.domain;

public enum Rank {
    LOSE(0, false, 0),
    W1(3, false, 5_000),
    W2(4, false, 50_000),
    W3(5, false, 1_500_000),
    W4(5, true, 30_000_000),
    W5(6, false, 2_000_000_000);

    private final int correctNumberAmount;
    private final boolean hasBonus;
    private final int prize;

    Rank(int correctNumberAmount, boolean hasBonus, int prize) {
        this.correctNumberAmount = correctNumberAmount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static Rank getRank(int correctNumberAmount, boolean hasBonus) {
        Rank[] rankEnums = Rank.values();
        for (Rank rank : rankEnums) {
            if (rank.getCorrectNumberAmount() == correctNumberAmount && rank.hasBonus() == hasBonus) {
                return rank;
            }
        }
        return Rank.LOSE;
    }

    public int getCorrectNumberAmount() {
        return this.correctNumberAmount;
    }

    public boolean hasBonus() {
        return this.hasBonus;
    }

    public int prize() {
        return this.prize;
    }


}
