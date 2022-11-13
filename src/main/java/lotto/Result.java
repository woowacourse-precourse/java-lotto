package lotto;

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

    public static int getTotalPrize() {
        int totalPrize = fifth * 5000 + fourth * 50000 + third * 1500000 + second * 30000000 + first * 2000000000;
        return totalPrize;
    }
}
