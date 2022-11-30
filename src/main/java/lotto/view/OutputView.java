package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;

public class OutputView {
    private final static String LOTTO_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String LOTTO_PURCHASE_COMPLETE_MESSAGE = "%d개를 구매했습니다.";
    private final static String LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final static String START_WINNING_STATISTICS_MESSAGE = "당첨 통계";
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

    public static void printWinningHistory(List<Integer> result) {
        System.out.println(START_WINNING_STATISTICS_MESSAGE);
        System.out.println("---");
        int i = 3;
        for (Rank rank : Rank.values()) {
            if (i == 6) {
                System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", i - 1, rank.getPrize(), result.get(i - 3)));
                i++;
                continue;
            }
            if (i == 7) {
                System.out.println(String.format("%d개 일치 (%,d원) - %d개", i - 1, rank.getPrize(), result.get(i - 3)));
                continue;
            }
            System.out.println(String.format("%d개 일치 (%,d원) - %d개", i, rank.getPrize(), result.get(i - 3)));
            i++;
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
