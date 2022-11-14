package lotto;

import java.util.List;

public class Yeild {
    private int money;
    private List<Integer> prizeCounts;
    private int prizeMoney;
    private double yeild;

    public Yeild(int money, List<Integer> prizeCounts) {
        this.money = money;
        this.prizeCounts = prizeCounts;
    }

    void createStatistic() {
        for (int i = 0; i < prizeCounts.size(); i++) {
            prizeMoney += Prize.values()[i].getMoney() * prizeCounts.get(i);
        }
        yeild = (Math.round(((double) prizeMoney / money) * 100 * 100));
    }

    public double getYeild() {
        return this.yeild;
    }
}
