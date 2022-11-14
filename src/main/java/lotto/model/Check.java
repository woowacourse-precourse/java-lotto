package lotto.model;

public class Check {

    private int count;
    private boolean bonus;

    public Check(int count, boolean bonus) {
        this.count = count;
        this.bonus = bonus;
    }

    public int getCount() {
        return count;
    }

    public boolean getBonus() {
        return bonus;
    }

    public void addCount() {
        count++;
    }

    public void isBonus() {
        bonus = true;
    }
}
