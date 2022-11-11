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

        printResult();
    }

    private void printResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for(Winning winning : Winning.getValues()) {
            System.out.println(winning.getMessage() + prize.get(winning) + "개");
        }
    }
}
