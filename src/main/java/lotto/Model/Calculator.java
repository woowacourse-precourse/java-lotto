package lotto.Model;

import java.util.List;

public class Calculator {
    public static final int UNIT_OF_MONEY = 1000;
    public static final int PERCENT = 100;

    private final List<WinningRank> rankResult;

    public Calculator(List<WinningRank> rankResult){
        this.rankResult = rankResult;
    }

    public List<WinningRank> getRankList() {
        return rankResult;
    }

    public double getSumOfWinningAmount(){
        double sum = 0;
        for (WinningRank rank : rankResult){
            sum += rank.WinningAmount();
        }
        return sum;
    }

    public int CountOfRank(WinningRank wantedRank) {
        int count = (int) rankResult.stream()
                .filter(rank -> rank.equals(wantedRank))
                .count();
        return count;
    }

    public double earnedRatio(){
        double sum = getSumOfWinningAmount();
        return (sum / (rankResult.size() * UNIT_OF_MONEY)) * PERCENT;
    }

    public static int divide1000(int num){
        return num / UNIT_OF_MONEY;

    }
}
