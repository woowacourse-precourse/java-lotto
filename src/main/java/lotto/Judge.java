package lotto;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    List<Integer> rankCount = new ArrayList<>();

    public void setRankCount(List<Lotto> lotteries, List<Integer> winningNumbers) {

        for (int i = 0; i < 6; i++) {
            rankCount.add(0);
        }

        for (Lotto lottery : lotteries) {
            int index = lottery.confirmNumbers(winningNumbers);
            if (index > 5)
                continue;
            rankCount.set(index, rankCount.get(index) + 1);
        }

    }

    public long countPrizeMoney() {
        long totalPrizeMoney = 0;

        for (int i = 1; i < 6; i++) {
            totalPrizeMoney += (long) rankCount.get(i) * rankPriceTable.valueOf("Price" + i).getTable2Value();
        }
        return totalPrizeMoney;
    }

    public double countEarningsRate(int money) {
        double rate = (double) countPrizeMoney() / money;
        return (double) Math.round(rate * 10) / 10;
    }

}

enum rankPriceTable {

    Price1(1, 2000000000),
    Price2(2, 30000000),
    Price3(3, 1500000),
    Price4(4, 50000),
    Price5(5, 5000);

    private Integer table1Value;
    private Integer table2Value;

    rankPriceTable(Integer table1Value, Integer table2Value) {
        this.table1Value = table1Value;
        this.table2Value = table2Value;
    }

    public Integer getTable1Value() {
        return table1Value;
    }

    public Integer getTable2Value() {
        return table2Value;
    }

}