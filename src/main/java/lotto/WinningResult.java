package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class WinningResult {
    private static WinningResult winningResult;

    private HashMap<Rank, Integer> prize;
    private final LottoMachine lottoMachine = LottoMachine.getInstance();

    private WinningResult() {
        prize = new HashMap<>();

        for (Rank rank : Rank.values()) {
            prize.put(rank, 0);
        }
    }

    public static WinningResult getInstance() {
        if (winningResult == null) {
            winningResult = new WinningResult();
        }

        return winningResult;
    }

    public void compileStatistics(List<Lotto> myLotteries) {
        Rank rank;

        for (Lotto lotto : myLotteries) {
            int compare = lotto.compare(lottoMachine.getWinningLottery());

            if (compare < Constants.WINNING_STANDARD) {
                continue;
            }

            rank = Rank.getWinning(compare, lotto.hasBonus(lottoMachine.getBonus()));
            prize.put(rank, Optional.ofNullable(prize.get(rank)).orElse(0) + 1);
        }

        printResult(myLotteries.size() * Constants.LOTTO_PRICE_UNIT);
    }

    private void printResult(int money) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.getValues()) {
            System.out.println(rank.getMessage() + prize.get(rank) + "개");
        }
        System.out.println("총 수익률은 " + getEarningsRate(money) + "%입니다.");
    }

    private double getEarningsRate(int money) {
        double totalPrize = 0;

        for (Rank rank : prize.keySet()) {
            totalPrize += rank.getCash() * prize.get(rank);
        }
        return (Constants.DECIMAL * totalPrize / money) * 100;
    }
}
