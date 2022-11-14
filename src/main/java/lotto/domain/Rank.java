package lotto.domain;

public enum Rank {
    LOSE(0, false, "0"),
    W1(3, false, "5,000"),
    W2(4, false, "50,000"),
    W3(5, false, "1,500,000"),
    W4(5, true, "30,000,000"),
    W5(6, false, "2,000,000,000");

    private final int correctNumberAmount;
    private final boolean hasBonus;
    private final String prize;

    Rank(int correctNumberAmount, boolean hasBonus, String prize) {
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

    public String prize() {
        return this.prize;
    }


}
