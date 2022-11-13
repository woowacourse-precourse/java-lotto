package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Result {
    public static int first;
    public static int second;
    public static int third;
    public static int fourth;
    public static int fifth;

    public Result() {
        first = 0;
        second = 0;
        third = 0;
        fourth = 0;
        fifth = 0;
        addResult(StartLotto.winChecks);
    }

    public static void addResult(List<WinCheck> winChecks) {
        for (WinCheck e : winChecks) {
            if (e.getMatchCnt() == 6)
                first++;
            if (e.getMatchCnt() == 5)
                if (e.isBonusMatch())
                    second++;
                else
                    third++;            //-> 고쳐야 함
            if (e.getMatchCnt() == 4)
                fourth++;
            if (e.getMatchCnt() == 3)
                fifth++;
        }
    }

    public static long getTotalPrize() {
        long totalPrize = fifth * 5000 + fourth * 50000 + third * 1500000 + second * 30000000 + first * 2000000000;
        return totalPrize;
    }

    public static BigDecimal calculate() {
        BigDecimal result1 = new BigDecimal(first * 2000000000);
        BigDecimal result2 = new BigDecimal(second * 30000000);
        BigDecimal result3 = new BigDecimal(third * 1500000);
        BigDecimal result4 = new BigDecimal(fourth * 50000);
        BigDecimal result5 = new BigDecimal(fifth * 5000);
        BigDecimal sum = result1.add(result2.add(result3.add(result4.add(result5))));
        BigDecimal moneyInput = new BigDecimal(StartLotto.payment);
        BigDecimal result = sum.multiply(new BigDecimal(100)).divide(moneyInput, 1, RoundingMode.HALF_EVEN);
        return result;
    }
}
