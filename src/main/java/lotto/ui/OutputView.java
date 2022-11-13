package lotto.ui;

import lotto.lotto.LottoManager;
import lotto.lotto.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String BUYING_N_AMOUNT = "개를 구매했습니다.";
    private static final String WINNING_STAT = "당첨통계\n---\n";
    private static final String EARNING_RATE_START = "총 수익률은 ";
    private static final String EARNING_RATE_END = "%입니다.";

    public static void outputBlankLine() {
        System.out.println();
    }

    public static void outputBuyingAmount(int buyingMoney) {
        System.out.println(buyingMoney / LottoManager.LOTTO_PRICE + BUYING_N_AMOUNT);
    }

    public static void outputLotto(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void outputWinningStat(Map<Rank, Integer> rankMap) {
        System.out.println(WINNING_STAT);
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            if (rank.equals(Rank.MISS)) {
                continue;
            }
            String line = "";
            line += rank.getStatus() + " (" + toCashFormat(rank.getWinningReward()) + "원)" + " - " + rankMap.get(rank) + "개";
            System.out.println(line);
        }
    }

    public static void outputEarningRate(String rate) {
        System.out.println(EARNING_RATE_START + rate + EARNING_RATE_END);
    }

    private static String toCashFormat(int cash) {
        return String.format("%,d", cash);
    }
}
