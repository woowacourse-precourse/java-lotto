package lotto.Model;

import java.util.List;

public class calculateIncome {
    private int income = 0;
    private final int[] winMoney = {5000, 50000, 1500000, 30000000, 2000000000};

    public calculateIncome(List<Integer> winResult) {
        this.income += winResult.get(0) * 5000;
        this.income += winResult.get(1) * 50000;
        this.income += winResult.get(2) * 1500000;
        this.income += winResult.get(3) * 30000000;
        this.income += winResult.get(4) * 2000000000;
    }

    public double getIncomeRate(int userMoney) {
        return Math.round((((double)income / userMoney)) * 100 * 10) / 10.0;
    }
}
