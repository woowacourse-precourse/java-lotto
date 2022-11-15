package lotto;

public class Result {
    private final int match;
    private final boolean bonus;

    public Result(int match, boolean bonus) {
        this.match = match;
        this.bonus = bonus;
    }

    public int getMatch() {
        return match;
    }

    public boolean isBonus() {
        return bonus;
    }
}
