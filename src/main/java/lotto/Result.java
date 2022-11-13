package lotto;

public class Result {
    private Lotto lotto;
    private int coincideCount;
    private int bonus;

    public Result(Lotto lotto, int coincideCount, int bonus) {
        this.lotto = lotto;
        this.coincideCount = coincideCount;
        this.bonus = bonus;
    }

    public int getCoincideCount() {
        return coincideCount;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "Result{" +
                "lotto=" + lotto +
                ", coincideCount=" + coincideCount +
                ", bonus=" + bonus +
                '}';
    }
}
