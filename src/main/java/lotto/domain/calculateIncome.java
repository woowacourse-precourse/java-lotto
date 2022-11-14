package lotto.domain;

import java.util.List;

public class calculateIncome {
    private int income = 0;

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
