package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TotalResult {
    public static int first;
    public static int second;
    public static int third;
    public static int fourth;
    public static int fifth;

    public TotalResult() {
        first = 0;
        second = 0;
        third = 0;
        fourth = 0;
        fifth = 0;
        for (WinCheck e : StartLotto.winChecks)
            addResult(e);
    }

    public static int getCount(int index) {
        if (index == 1)
            return first;
        if (index == 2)
            return second;
        if (index == 3)
            return third;
        if (index == 4)
            return fourth;
        if (index == 5)
            return fifth;
        return 0;
    }

    public static void addResult(WinCheck winChecks) {
        if (winChecks.getMatchCount() == 6)
            first++;
        if (winChecks.getMatchCount() == 5) {
            if (winChecks.isBonusMatch()) {
                second++;
                return;
            }
            third++;
        }
        if (winChecks.getMatchCount() == 4)
            fourth++;
        if (winChecks.getMatchCount() == 3)
            fifth++;
    }

    public static BigDecimal totalPrize() {
        BigDecimal firstPrize = new BigDecimal(first * 2000000000);
        BigDecimal secondPrize = new BigDecimal(second * 30000000);
        BigDecimal thirdPrize = new BigDecimal(third * 1500000);
        BigDecimal fourthPrize = new BigDecimal(fourth * 50000);
        BigDecimal fifthPrize = new BigDecimal(fifth * 5000);
        BigDecimal sum = firstPrize.add(secondPrize).add(thirdPrize).add(fourthPrize).add(fifthPrize);
        return sum;
    }

    public static String calculate() {
        BigDecimal moneyInput = new BigDecimal(StartLotto.payment);
        BigDecimal revenue = totalPrize()
                .multiply(new BigDecimal(100))
                .divide(moneyInput, 1, RoundingMode.HALF_EVEN);
        return new DecimalFormat("###,##0.0").format(revenue);
    }
}
