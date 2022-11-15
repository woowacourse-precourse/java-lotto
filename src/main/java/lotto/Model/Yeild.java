package lotto.Model;

import lotto.Model.enums.Prize;

import java.util.List;

public class Yeild {
    private int money;
    private int prizeMoney;
    private double yeild;

    public Yeild(int money) {
        this.money = money;
        this.prizeMoney = 0;
    }

    public void createStatistic() {
        for (int i = 0; i<5; i++) {
            prizeMoney += Prize.values()[i].getMoney() * Prize.values()[i].getPrizeCount();
        }
        yeild = Math.round(((double) prizeMoney / money)* 100*100)/100.0;
    }

    public double getYeild() {
        return this.yeild;
    }
}
