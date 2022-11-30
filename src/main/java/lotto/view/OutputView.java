package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private final static String LOTTO_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String LOTTO_PURCHASE_COMPLETE_MESSAGE = "%d개를 구매했습니다.";
    private final static String LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final static String START_WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private final static String DIVIDING_LINE = "---";
    private final static String RESULT = "%d개 일치 (%,d원) - %d개";
    private final static String SECOND_RESULT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private final static int[] PRIZE_MONEY = {5000, 50000, 1500000, 30000000, 2000000000};


    public static void printLottoPurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_MESSAGE);
    }

    public static void printLottoPurchaseCompleteAmount(int quantity) {
        System.out.println(String.format(LOTTO_PURCHASE_COMPLETE_MESSAGE, quantity));
    }

    public static void printLottoFormatting(List<Lotto> purchaseLotto) {
        for (Lotto lotto : purchaseLotto) {
            System.out.println(lotto.toString());
        }
    }

    public static void printLottoNumbers() {
        System.out.println(LOTTO_NUMBERS_MESSAGE);
    }

    public static void printLottoBonusNumber() {
        System.out.println(LOTTO_BONUS_NUMBER_MESSAGE);
    }

    private static void printWinStatisticsMessage() {
        System.out.println(START_WINNING_STATISTICS_MESSAGE);
        System.out.println(DIVIDING_LINE);
    }

    public static void printLottoResult(Map<Rank, Integer> result) {
        printWinStatisticsMessage();
        Rank[] rank = Rank.values();
        for (int i = rank.length - 2; i >= 0; i--) {
            int count = 0;
            if (result.containsKey(rank[i])) count = result.get(rank[i]);

            if (i == 1) {
                System.out.println(String.format(SECOND_RESULT, rank[i].getMatchCount(), rank[i].getPrize(), count));
                continue;
            }
            System.out.println(String.format(RESULT, rank[i].getMatchCount(), rank[i].getPrize(), count));
        }
    }

    public static void printGrossProfit(List<Integer> result, int purchaseAmount) {
        int sumTotal = 0;
        int moneyIndex = 0;
        for (int count : result) {
            sumTotal += (PRIZE_MONEY[moneyIndex] * count);
            moneyIndex++;
        }
        double grossProfit = (sumTotal * 1.0) / purchaseAmount * 100;
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", grossProfit));
    }
}
