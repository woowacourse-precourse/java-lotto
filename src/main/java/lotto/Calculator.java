package lotto;

import java.util.List;

public class Calculator {
    final int money;
    final List<Prize> prizes;

    Calculator(int amount, List<Prize> prizes) {
        this.money = amount * 1000;
        this.prizes = prizes;
    }

    public double profit() {
        int benefit = 0;

        for (Prize prize : prizes) {
            benefit += prize.reward();
        }

        return Math.round(benefit * 100 * 10 / money) / 10.0;
    }
}
