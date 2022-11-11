package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Award {
    private static Award award;

    private final int prizeStandard = 3;
    private HashMap<Winning, Integer> prize;
    private final LotteryMachine lotteryMachine = LotteryMachine.getInstance();

    private Award() {
        prize = new HashMap<>();
        for(Winning winning : Winning.values()) {
            prize.put(winning, 0);
        }
    }

    public static Award getInstance() {
        if(award == null) {
            award = new Award();
        }

        return award;
    }

    public void compileStatistics(List<Lotto> myLotteries) {
        Winning winning;
        Lotto winningLottery = lotteryMachine.getWinningLottery();

        for(Lotto lotto : myLotteries) {
            int compare = lotto.compare(winningLottery);

            if(compare < 3) {
                continue;
            }

            winning = Winning.getWinning(compare, lotto.isValidBonus(lotteryMachine.getBonus()));
            prize.put(winning, Optional.ofNullable(prize.get(winning)).orElse(0) + 1);
        }

        printResult(myLotteries.size() * 1000);
    }

    private void printResult(int money) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for(Winning winning : Winning.getValues()) {
            System.out.println(winning.getMessage() + prize.get(winning) + "개");
        }
        System.out.println("총 수익률은 " + getRevenueRate(money) + "%입니다.");
    }

    private double getRevenueRate(int money) {
        double revenue = 0;

        for(Winning winning : prize.keySet()) {
            revenue += winning.getCash() * prize.get(winning);
        }

        return getRoundDecimal(revenue / money);
    }

    private double getRoundDecimal(double decimal) {
        return (double)((int)(decimal * 1000)) / 10;
    }
}
