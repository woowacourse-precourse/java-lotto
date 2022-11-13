package lotto;

import java.util.List;

public class Result {
    public static int first;
    public static int second;
    public static int third;
    public static int fourth;
    public static int fifth;
    public static int totalPrize;

    public Result(List<Check> checks) {
        first = 0;
        second = 0;
        third = 0;
        fourth = 0;
        fifth = 0;
        totalPrize = 0;
        resultAdd(checks);
    }

    public static void resultAdd(List<Check> checks) {
        for (Check e : checks) {
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
    public static int getFirst() {
        return first;
    }

    public static int getSecond() {
        return second;
    }

    public static int getThird() {
        return third;
    }

    public static int getFourth() {
        return fourth;
    }

    public static int getFifth() {
        return fifth;
    }
    public static int getTotalPrize(){
        int total = fifth * 5000 + fourth * 50000 + third * 1500000 + second * 30000000 + first * 2000000000;
        return total;
    }
}
