package lotto.domain;

enum Rank {
    RANK1(6, false, 2_000_000_000),
    RANK2(5, true, 30_000_000),
    RANK3(5, false, 1_500_000),
    RANK4(4, false, 50_000),
    RANK5(3, false, 5_000),
    LOSE(0, false, 0);

    private final int correctNumberAmount;
    private final boolean hasBonus;
    private final int prize;

    Rank(int correctNumberAmount, boolean hasBonus, int prize) {
        this.correctNumberAmount = correctNumberAmount;
        this.hasBonus = hasBonus;
        this.prize = prize;
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
