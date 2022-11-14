package lotto.status.rank;

public enum RankBonusStatus {
    rank1(false),
    rank2(true),
    rank3(false),
    rank4(false),
    rank5(false);

    private boolean bonus;

    RankBonusStatus(boolean bonus) {
        this.bonus = bonus;
    }

    public boolean getBonus() {
        return bonus;
    }
}
