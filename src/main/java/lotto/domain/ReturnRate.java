package lotto.domain;

import java.util.HashMap;

import static lotto.message.GameMessage.*;
import static lotto.message.GameMessage.Return_Rate_Postfix;

public class ReturnRate {
    private final int origin;
    private final Long profit;
    public ReturnRate(int money, HashMap<Integer, Integer> winningStat) {
        this.origin = money;
        this.profit = (long) ((winningStat.get(5) * 5000) + (winningStat.get(4) * 50000) +
                (winningStat.get(3) * 1500000) + (winningStat.get(2) * 30000000) +
                (winningStat.get(1) * 2000000000));
        calculate();
    }

    private void calculate() {
        double total = Math.round((origin / profit) * 100);
        display(total);
    }

    private void display(double total) {
        System.out.println(Return_Rate_Prefix +
                String.format("%.2f", total) +
                Return_Rate_Postfix);
    }
}
