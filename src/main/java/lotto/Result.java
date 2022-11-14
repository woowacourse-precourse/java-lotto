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

    public static BigDecimal totalPrize() {
        BigDecimal firstPrize = new BigDecimal(first * 2000000000);
        BigDecimal secondPrize = new BigDecimal(second * 30000000);
        BigDecimal thirdPrize = new BigDecimal(third * 1500000);
        BigDecimal fourthPrize = new BigDecimal(fourth * 50000);
        BigDecimal fifthPrize = new BigDecimal(fifth * 5000);
        BigDecimal sum = firstPrize.add(secondPrize.add(thirdPrize.add(fourthPrize.add(fifthPrize))));
        return sum;
    }

    public static BigDecimal calculate() {
        BigDecimal moneyInput = new BigDecimal(StartLotto.payment);
        BigDecimal revenue = totalPrize().multiply(new BigDecimal(100)).divide(moneyInput, 1, RoundingMode.HALF_EVEN);
        return revenue;
    }
}
