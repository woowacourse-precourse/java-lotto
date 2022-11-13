package lotto.Model;

import java.util.List;

public class Calculator {
    public static final int UNIT_OF_MONEY = 1000;

    private final List<WinningRank> rankResult;

    public Calculator(List<WinningRank> rankResult){
        this.rankResult = rankResult;
    }

    public List<WinningRank> getRankList() {
        return rankResult;
    }

    public static int divide1000(int num){
        return num / UNIT_OF_MONEY;

    }
}
