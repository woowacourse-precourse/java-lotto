package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningMoney {
    private final List<Integer> RANKCOUNT;
    private final int MONEY;
    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;

    public WinningMoney(List<Integer> rank){
        RANKCOUNT = winningRank(rank);
        MONEY = winningMoney();
    }

    public List<Integer> winningRank(List<Integer> rank) {
        List<Integer> rankCount = new ArrayList<>();
        first = Collections.frequency(rank, 1);
        second = Collections.frequency(rank, 2);
        third = Collections.frequency(rank, 3);
        fourth = Collections.frequency(rank, 4);
        fifth = Collections.frequency(rank, 5);

        rankCount.add(first);
        rankCount.add(second);
        rankCount.add(third);
        rankCount.add(fourth);
        rankCount.add(fifth);

        return rankCount;
    }

    public int winningMoney() {
        int money = first*2000000000 +  second*30000000
                + third*1500000 + fourth*50000 + fifth*5000;

        return money;
    }

    public List<Integer> getRANKCOUNT() {
        return RANKCOUNT;
    }

    public int getMONEY() {
        return MONEY;
    }
}
